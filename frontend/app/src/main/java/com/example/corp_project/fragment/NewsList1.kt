package com.example.corp_project.fragment

import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.corp_project.News
import com.example.corp_project.NewsAdapter
import com.example.corp_project.R
import com.example.corp_project.databinding.FragmentNewsList1Binding


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

        val firstData: MutableList<News> = mutableListOf(
            News("WHO, 코로나19 국제적 비상사태 종료 선언 조건 검토 시작"),
            News("코로나19 신규 환자 38만여 명...역대 최다"),
            News("오후 9시까지 33만7452명 코로나19 신규확진…어제보다 7260명↓"),
            News("아시아 지역 코로나19 사망자, 100만명 돌파"),
            News("질병청 “학생들 코 대신 입으로 코로나19 검사 허용”")
        )

        val adapter = NewsAdapter()
        adapter.NewsList = firstData

        nbinding?.newsList1?.layoutManager =
            LinearLayoutManager(activity)
        nbinding?.newsList1?.adapter = adapter

        val decoration =
        nbinding?.newsList1?.addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager(activity).orientation))



    }

    override fun onDestroyView() {
        super.onDestroyView()
        nbinding = null
    }


}