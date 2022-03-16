package com.example.corp_project.fragment

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.corp_project.News
import com.example.corp_project.titleList
import com.example.corp_project.NewsAdapter
import com.example.corp_project.databinding.FragmentNewsList3Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


class NewsList3 : Fragment() {
    private var nbinding3:FragmentNewsList3Binding?=null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        nbinding3 = FragmentNewsList3Binding.inflate(inflater, container, false)

        val view = nbinding3?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var keyword = arguments?.getString("tag")


        val adapter = NewsAdapter()
        //adapter.NewsList = thirdData

        nbinding3?.newsList3?.layoutManager =
            LinearLayoutManager(activity)
        nbinding3?.newsList3?.adapter = adapter

        val decoration =
            nbinding3?.newsList3?.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    LinearLayoutManager(activity).orientation
                )
            )


        val retrofit = Retrofit.Builder().baseUrl("http://3.37.205.195:8000/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val getNewsService = retrofit.create(NewsList3.getNewsService::class.java)
        getNewsService.getTitles(keyword!!).enqueue(object: Callback<List<News>> {

            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                Log.d(ContentValues.TAG, "실패 : $t")
            }

            override fun onResponse(
                call: Call<List<News>>,
                response: Response<List<News>>
            ) {
                adapter.NewsList.addAll(response.body() as List<News>)
                adapter.notifyDataSetChanged()
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        nbinding3 = null
    }


    interface getNewsService{
        @GET("news")
        fun getTitles(@Query("query") tag:String):Call<List<News>>
    }

}