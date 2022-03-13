package com.example.corp_project

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.corp_project.databinding.ActvitySettingTagBinding

class TagActivity : AppCompatActivity() {

    //ViewBinding
    lateinit var tBinding: ActvitySettingTagBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tBinding = ActvitySettingTagBinding.inflate(layoutInflater)
        val view = tBinding.root
        setContentView(view)


        //사용할 데이터를 생성하는 코드
        var tagData: ArrayList<Tag> = ArrayList()
        //넘겨줄 데이터를 담은 List
        var tagList: ArrayList<String> = ArrayList()

        //어댑터를 생성하고 데이터 목록 저장
        var adapter = TagAdapter()
        adapter.tagData = tagData

        tBinding.addTagLayout.adapter = adapter
        tBinding.addTagLayout.layoutManager = GridLayoutManager(this, 3)

        tBinding.tagAddBtn.setOnClickListener {
            if (tagList.size > 4) {
                Toast.makeText(this@TagActivity, "추가할 수 있는 해시태그 갯수를 초과했습니다.", Toast.LENGTH_SHORT)
                    .show()
            } else {
                var tagName = tBinding.enterTag.text.toString()
                adapter.addTag(Tag(tagName))
                tagList.add(tagName)
                adapter.notifyDataSetChanged()
            }
        }


        //추천 키워드를 클릭했을 때
        //이미 입력한 키워드가 5개 이상 ->  더이상 추가할 수 없도록 설계
        tBinding.suggestTag1.setOnClickListener {

            if (tagList.size > 4) {
                Toast.makeText(this@TagActivity, "추가할 수 있는 해시태그 갯수를 초과했습니다.", Toast.LENGTH_SHORT)
                    .show()
            } else {

                tBinding.suggestTag1.setBackgroundResource(R.drawable.input_box)
                tBinding.suggestTag1.setTextColor(Color.parseColor("#FFFFFF"))

                var suggestTag = tBinding.suggestTag1.text.toString()
                tagList.add(suggestTag)
            }
        }

        tBinding.suggestTag2.setOnClickListener {

            if (tagList.size > 4) {
                Toast.makeText(this@TagActivity, "추가할 수 있는 해시태그 갯수를 초과했습니다.", Toast.LENGTH_SHORT)
                    .show()
            } else {

                tBinding.suggestTag2.setBackgroundResource(R.drawable.input_box)
                tBinding.suggestTag2.setTextColor(Color.parseColor("#FFFFFF"))

                var suggestTag = tBinding.suggestTag2.text.toString()
                tagList.add(suggestTag)
            }
        }

        tBinding.suggestTag3.setOnClickListener {

            if (tagList.size > 4) {
                Toast.makeText(this@TagActivity, "추가할 수 있는 해시태그 갯수를 초과했습니다.", Toast.LENGTH_SHORT)
                    .show()
            } else {

                tBinding.suggestTag3.setBackgroundResource(R.drawable.input_box)
                tBinding.suggestTag3.setTextColor(Color.parseColor("#FFFFFF"))

                var suggestTag = tBinding.suggestTag3.text.toString()
                tagList.add(suggestTag)
            }
        }

        tBinding.suggestTag4.setOnClickListener {

            if (tagList.size > 4) {
                Toast.makeText(this@TagActivity, "추가할 수 있는 해시태그 갯수를 초과했습니다.", Toast.LENGTH_SHORT)
                    .show()
            } else {

                tBinding.suggestTag4.setBackgroundResource(R.drawable.input_box)
                tBinding.suggestTag4.setTextColor(Color.parseColor("#FFFFFF"))

                var suggestTag = tBinding.suggestTag4.text.toString()
                tagList.add(suggestTag)
            }
        }

        tBinding.suggestTag5.setOnClickListener {

            if (tagList.size > 4) {
                Toast.makeText(this@TagActivity, "추가할 수 있는 해시태그 갯수를 초과했습니다.", Toast.LENGTH_SHORT)
                    .show()
            } else {

                tBinding.suggestTag5.setBackgroundResource(R.drawable.input_box)
                tBinding.suggestTag5.setTextColor(Color.parseColor("#FFFFFF"))

                var suggestTag = tBinding.suggestTag5.text.toString()
                tagList.add(suggestTag)
            }
        }
        
        //해시태그 저장 버튼
        tBinding.saveBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("tagList", tagList)
            startActivity(intent)
        }


    }


}