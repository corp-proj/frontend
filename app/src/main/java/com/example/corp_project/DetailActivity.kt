package com.example.corp_project

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.corp_project.databinding.ActivityDetailBinding
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

class DetailActivity : AppCompatActivity() {
    lateinit var detailBinding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val newsTitle = intent.getStringExtra("title")

        val newsUrl = intent.getStringExtra("url")

        val fullText = intent.getStringExtra("content")

        //val respondData = ArrayList<Detail>()

        val detailBinding = ActivityDetailBinding.inflate(layoutInflater)

        val view = detailBinding.root
        setContentView(view)

       /*
        //배경 이미지
        Glide.with(this)
            .load(detailInfo.get(0).toString())
            .into(detailBinding.newsBackground)
            */


        //뒤로 돌아가는 버튼
        detailBinding.icBackspace.setOnClickListener {
            val back = Intent(this, MainActivity::class.java)
            startActivity(back)
        }

        //기사 제목
        detailBinding.newsTitle.setText(newsTitle)


        //전문 보기 버튼
        detailBinding.btnNewsDetail.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsUrl.toString()))
            startActivity(intent)
        }


         //요약모델 받아오기
         val retrofit = Retrofit.Builder().baseUrl("http://3.37.205.195:8000/api/")
             .addConverterFactory(GsonConverterFactory.create()).build()

         val summaryService = retrofit.create(GetSummary::class.java)

        //body 만들기
        val input = Summary(fullText.toString(), "")


         summaryService.newsDetail(input).enqueue(object: Callback<Detail> {

             override fun onFailure(call: Call<Detail>, t: Throwable) {
                 Log.d(ContentValues.TAG, "실패 : $t")
             }

             override fun onResponse(
                 call: Call<Detail>,
                 response: Response<Detail>
             ) {
                 val responseCotent : Detail = response.body()!!
                 detailBinding.newsContent.setText(responseCotent.summarized.toString())
             }
         })


    }

    interface GetSummary {
        @Headers("accept: application/json", "content-type: application/json")
        @POST("hashtag")
        fun newsDetail(@Body params:Summary): Call<Detail>
    }


}