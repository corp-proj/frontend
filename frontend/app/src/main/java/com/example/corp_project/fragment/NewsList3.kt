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
import com.example.corp_project.databinding.FragmentNewsList2Binding
import com.example.corp_project.databinding.FragmentNewsList3Binding


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


        val thirdData: MutableList<News> = mutableListOf(
            News("삼성, 갤럭시S22 'GOS 강제 적용' 해제…소비자 불만 여전"),
            News("'성능제한 논란' 갤럭시S22 업데이트…노태문 사장 사과"),
            News("'흥행' 아닌 '불행'? 삼성 갤럭시에 닥친 3중고"),
            News("공정위, 갤럭시S22 ‘GOS’ 표시광고법 위반 의혹 본격 조사"),
            News("갤럭시S22 'GOS 논란' 이렇게 커질 줄이야…집단소송 가나")
        )

        val adapter = NewsAdapter()
        adapter.NewsList = thirdData

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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        nbinding3 = null
    }

}