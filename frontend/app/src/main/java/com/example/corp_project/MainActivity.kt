package com.example.corp_project

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.corp_project.databinding.ActivityMainBinding
import com.example.corp_project.fragment.NewsList1
import com.example.corp_project.fragment.NewsList2
import com.example.corp_project.fragment.NewsList3


class MainActivity : AppCompatActivity() {

    lateinit var mbinding: ActivityMainBinding
    var clickcnt = 1;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mbinding.root
        setContentView(view)

        val tagData = intent.getStringArrayListExtra("tagList")
        
        //사용자가 선택한 태그를 메인화면에 보여주는 코드
        mbinding.mainTag1.setText(tagData?.get(0))
        mbinding.mainTag2.setText(tagData?.get(1))
        mbinding.mainTag3.setText(tagData?.get(2))
        mbinding.mainTag4.setText(tagData?.get(3))
        mbinding.mainTag5.setText(tagData?.get(4))
        

        
       //관심있는 해시태그를 등록했을 떄, 관련 기사 제목들을 보여줄 수 있도록 설계
        mbinding.mainTag1.setOnClickListener {
            if (clickcnt % 2 != 0) {
                mbinding.mainTag1.setBackgroundResource(R.drawable.input_box)
                mbinding.mainTag1.setTextColor(Color.parseColor("#FFFFFF"))

                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(
                    R.id.news_list_page,
                    NewsList1()
                )
                transaction.commit()
            } else {
                mbinding.mainTag1.setBackgroundResource(R.drawable.suggest_word)
                mbinding.mainTag1.setTextColor(Color.parseColor("#000000"))
                removeFragment()
            }
            clickcnt++

        }

        mbinding.mainTag2.setOnClickListener {
            if (clickcnt % 2 != 0) {
                mbinding.mainTag2.setBackgroundResource(R.drawable.input_box)
                mbinding.mainTag2.setTextColor(Color.parseColor("#FFFFFF"))

                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(
                    R.id.news_list_page,
                    NewsList2()
                )
                transaction.commit()
            } else {
                mbinding.mainTag2.setBackgroundResource(R.drawable.suggest_word)
                mbinding.mainTag2.setTextColor(Color.parseColor("#000000"))
                removeFragment()
            }
            clickcnt++

        }

        mbinding.mainTag3.setOnClickListener {
            if (clickcnt % 2 != 0) {
                mbinding.mainTag3.setBackgroundResource(R.drawable.input_box)
                mbinding.mainTag3.setTextColor(Color.parseColor("#FFFFFF"))

                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(
                    R.id.news_list_page,
                    NewsList3()
                )
                transaction.commit()
            } else {
                mbinding.mainTag3.setBackgroundResource(R.drawable.suggest_word)
                mbinding.mainTag3.setTextColor(Color.parseColor("#000000"))
                removeFragment()
            }
            clickcnt++

        }


    }
    
    
    //프래그먼트를 제거하는 함수
    private fun removeFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        val frameLayout = supportFragmentManager.findFragmentById(R.id.news_list_page)
        transaction.remove(frameLayout!!)
        transaction.commit()
    }


}