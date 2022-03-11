package com.example.corp_project

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.corp_project.databinding.ActvitySettingTagBinding

class TagActivity:AppCompatActivity() {

    //ViewBinding
    lateinit var tBinding : ActvitySettingTagBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tBinding = ActvitySettingTagBinding.inflate(layoutInflater)
        val view = tBinding.root
        setContentView(view)

        //사용할 데이터를 생성하는 코드
        var data:MutableList<Tag> = mutableListOf()

        //어댑터를 생성하고 데이터 목록 저장
        var adapter = TagAdapter()
        adapter.tagData = data

        tBinding.addTagLayout.adapter = adapter
        tBinding.addTagLayout.layoutManager = GridLayoutManager(this,4)

        tBinding.tagAddBtn.setOnClickListener {
            var tagName = tBinding.enterTag.text.toString()
            adapter.addTag(Tag(tagName))
            adapter.notifyDataSetChanged()
        }




    }




}