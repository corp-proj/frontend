package com.example.corp_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.corp_project.databinding.InputTagBinding

class TagAdapter : RecyclerView.Adapter<Holder>() {
    var tagData = mutableListOf<Tag>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //아이템 레이아웃을 생성, 한 화면에 8줄이 보이면 8번 호출됨

        val binding = InputTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //데이터와 레이아웃을 연결하는 메서드

        val tag = tagData.get(position)
        holder.setTag(tag)

    }


    fun addTag(item: Tag) {
        tagData.add(item)
    }


    fun getTag(position: Int): Tag {
        return tagData.get(position)
    }


    fun setTag(position: Int, item: Tag) {
        tagData.set(position, item)
    }


    override fun getItemCount(): Int {
        //리사이클러뷰에서 사용할 데이터의 총 개수를 리턴하는 메서드
        return tagData.size
    }
}

class Holder(val binding: InputTagBinding) : RecyclerView.ViewHolder(binding.root) {

    var mTag: Tag? = null
    var mPosition: Int? = null


    fun setTag(tag: Tag) {
        binding.inputTagText.text = tag.name
        this.mTag = tag
        this.mPosition = position
    }

}
