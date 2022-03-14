package com.example.corp_project.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.corp_project.News
import com.example.corp_project.NewsAdapter
import com.example.corp_project.R
import com.example.corp_project.databinding.FragmentNewsList1Binding
import com.example.corp_project.databinding.FragmentNewsList2Binding


class NewsList2 : Fragment() {
    private var nbinding: FragmentNewsList2Binding? = null
    private val binding get() = nbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        nbinding = FragmentNewsList2Binding.inflate(inflater, container, false)

        val view = nbinding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val secondData: MutableList<News> = mutableListOf(
            News("패럴림픽 아쉬운 노메달…절실한 지원 · 세대교체"),
            News("[패럴림픽] 첫 대회 마무리한 최연소 최사라 \"다음 목표는 메달\""),
            News("베이징 동계 패럴림픽, 열흘간의 일정 마치고 폐막"),
            News("베이징 패럴림픽 10일 열전 마무리…'4년 뒤 밀라노에서 만나요'"),
            News("‘전쟁 속에 피운 평화’… 우크라이나 금메달 11개 패럴림픽 2위")
        )

        val adapter = NewsAdapter()
        adapter.NewsList = secondData

        nbinding?.newsList2?.layoutManager =
            LinearLayoutManager(activity)
        nbinding?.newsList2?.adapter = adapter

        val decoration =
            nbinding?.newsList2?.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    LinearLayoutManager(activity).orientation
                )
            )


    }

    override fun onDestroyView() {
        super.onDestroyView()
        nbinding = null
    }


}

