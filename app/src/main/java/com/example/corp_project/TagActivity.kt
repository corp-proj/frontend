package com.example.corp_project

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
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


        //리사이클러 뷰에서 사용할 데이터를 생성하는 코드
        var tagData: ArrayList<Tag> = ArrayList()

        //넘겨줄 데이터를 담은 List
        var tagList: ArrayList<String> = ArrayList()


        //추천 해시태그
        var suggestTag:String


        //어댑터를 생성하고 데이터 목록 저장
        val adapter = TagAdapter()
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

        //터치하면 해시태그를 삭제하도록
        adapter.setItemClickListener(object : TagAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                Toast.makeText(
                    this@TagActivity,
                    "태그가 삭제되었습니다.",
                    Toast.LENGTH_SHORT
                ).show()
                tagData.removeAt(position)
                adapter.notifyDataSetChanged()
                tagList.removeAt(position)
            }
        })

        //추천 키워드를 클릭했을 때
        //이미 입력한 키워드가 5개 이상 ->  더이상 추가할 수 없도록 설계
        tBinding.suggestTag1.setOnClickListener {
            //터치 횟수에 따른 이벤트를 처리하기 위한 변수
            var touchcnt = 0
            if (touchcnt % 2 == 0) {
                if (tagList.size > 4) {
                    Toast.makeText(
                        this@TagActivity,
                        "추가할 수 있는 해시태그 갯수를 초과했습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    btnClicked(tBinding.suggestTag1)
                    suggestTag = tBinding.suggestTag1.text.toString()
                    tagList.add(suggestTag)
                }
            } else {
                //터치했을때 해시태그 삭제
                btnUnclicked(tBinding.suggestTag1)
                var index = tagList.indexOf(tBinding.suggestTag1.text)
                tagList.removeAt(index)
            }
            touchcnt++
        }

        tBinding.suggestTag2.setOnClickListener {
            //터치 횟수에 따른 이벤트를 처리하기 위한 변수
            var touchcnt = 0
            if (touchcnt % 2 == 0) {
                if (tagList.size > 4) {
                    Toast.makeText(
                        this@TagActivity,
                        "추가할 수 있는 해시태그 갯수를 초과했습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    btnClicked(tBinding.suggestTag2)
                    suggestTag = tBinding.suggestTag2.text.toString()
                    tagList.add(suggestTag)
                }
            } else {
                //터치했을때 해시태그 삭제
                btnUnclicked(tBinding.suggestTag2)
                var index = tagList.indexOf(tBinding.suggestTag2.text)
                tagList.removeAt(index)
            }
            touchcnt++
        }

        tBinding.suggestTag3.setOnClickListener {
            //터치 횟수에 따른 이벤트를 처리하기 위한 변수
            var touchcnt = 0
            if (touchcnt % 2 == 0) {
                if (tagList.size > 4) {
                    Toast.makeText(
                        this@TagActivity,
                        "추가할 수 있는 해시태그 갯수를 초과했습니다.",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    btnClicked(tBinding.suggestTag3)
                    suggestTag = tBinding.suggestTag3.text.toString()
                    tagList.add(suggestTag)
                }
            } else {
                btnUnclicked(tBinding.suggestTag3)
                var index = tagList.indexOf(tBinding.suggestTag3.text)
                tagList.removeAt(index)
            }
            touchcnt++
        }

        tBinding.suggestTag4.setOnClickListener {
            var touchcnt = 0
            if (touchcnt % 2 == 0) {
                if (tagList.size > 4) {
                    Toast.makeText(
                        this@TagActivity,
                        "추가할 수 있는 해시태그 갯수를 초과했습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    btnClicked(tBinding.suggestTag4)
                    suggestTag = tBinding.suggestTag4.text.toString()
                    tagList.add(suggestTag)
                }
            } else {
                btnUnclicked(tBinding.suggestTag4)
                var index = tagList.indexOf(tBinding.suggestTag4.text)
                tagList.removeAt(index)

            }
            touchcnt++
        }

        tBinding.suggestTag5.setOnClickListener {
            var clickcnt = 0
            if (clickcnt % 2 == 0) {
                if (tagList.size > 4) {
                    Toast.makeText(
                        this@TagActivity,
                        "추가할 수 있는 해시태그 갯수를 초과했습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    btnClicked(tBinding.suggestTag5)
                    suggestTag = tBinding.suggestTag5.text.toString()
                    tagList.add(suggestTag)
                }
            } else {
                btnUnclicked(tBinding.suggestTag5)
                var index = tagList.indexOf(tBinding.suggestTag5.text)
                tagList.removeAt(index)
            }
            clickcnt++
        }


        //해시태그 저장 버튼
        tBinding.saveBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("tagList", tagList)
            startActivity(intent)
        }


    }

    fun btnClicked(button: Button) {
        button.setBackgroundResource(R.drawable.input_box)
        button.setTextColor(Color.parseColor("#FFFFFF"))
    }

    fun btnUnclicked(button: Button) {
        button.setBackgroundResource(R.drawable.suggest_word)
        button.setTextColor(Color.parseColor("#000000"))
    }


}