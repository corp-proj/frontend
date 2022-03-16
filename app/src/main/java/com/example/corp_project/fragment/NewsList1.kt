package com.example.corp_project.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.corp_project.News
import com.example.corp_project.NewsAdapter
import com.example.corp_project.databinding.FragmentNewsList1Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


class NewsList1 : Fragment() {

    private var nbinding: FragmentNewsList1Binding? = null
    private val binding get() = nbinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        nbinding = FragmentNewsList1Binding.inflate(inflater, container, false)

        val view = nbinding?.root
        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var keyword = arguments?.getString("tag")

        val adapter = NewsAdapter()

        nbinding?.newsList1?.layoutManager =
            LinearLayoutManager(activity)
        nbinding?.newsList1?.adapter = adapter

        val decoration =
            nbinding?.newsList1?.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    LinearLayoutManager(activity).orientation
                )
            )


        val retrofit = Retrofit.Builder().baseUrl("http://3.37.205.195:8000/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val getNewsService = retrofit.create(getNewsService::class.java)
        getNewsService.getTitles(keyword!!).enqueue(object:Callback<List<News>>{

            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                Log.d(TAG, "실패 : $t")
            }

            override fun onResponse(
                call: Call<List<News>>,
                response: Response<List<News>>
            ) {
                adapter.NewsList.addAll(response.body() as List<News>)
                //adapter.NewsList = response.body() as MutableList<News>
                adapter.notifyDataSetChanged()
            }
        })
        Log.d("키워드 출력","${keyword}")


    }

    override fun onDestroyView() {
        super.onDestroyView()
        nbinding = null
    }


    interface getNewsService{
        @GET("news")
        fun getTitles(@Query("query") tag:String):Call<List<News>>
    }



}