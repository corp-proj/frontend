package com.example.corp_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.corp_project.databinding.NewsListBinding

class NewsAdapter : RecyclerView.Adapter<NewsHolder>() {
    var NewsList = mutableListOf<News>()

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

        //간격 조절
        val layoutParams = holder.itemView.layoutParams
        layoutParams.height = 130
        holder.itemView.requestLayout()

    }
}

class NewsHolder(val nbinding: NewsListBinding) : RecyclerView.ViewHolder(nbinding.root) {

    fun setTitle(news: News) {
        nbinding.newsTitle.text = news.title
    }



}