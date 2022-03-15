package com.example.corp_project

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.corp_project.databinding.NewsListBinding


class NewsAdapter : RecyclerView.Adapter<NewsHolder>() {
    var NewsList = mutableListOf<News>()
    lateinit var nbinding: NewsListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        return NewsHolder(
            NewsListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun getItemCount(): Int {
        return NewsList.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {

        val news = NewsList.get(position)
        holder.setTitle(news)

        //리스트를 클릭했을 때 뉴스 보기 화면으로 전환
        holder. nbinding.newsTitle.setOnClickListener(View.OnClickListener { v ->
            var intent = Intent(v.context, DetailActivity::class.java)
            intent.putExtra("title", news.toString())
            v.context.startActivity(intent)
        })


       //간격 조절
        val layoutParams = holder.itemView.layoutParams
        layoutParams.height = 150
        holder.itemView.requestLayout()

    }
}

class NewsHolder(val nbinding: NewsListBinding) : RecyclerView.ViewHolder(nbinding.root) {

    fun setTitle(news: News) {
        nbinding.newsTitle.text = news.title
    }


}

