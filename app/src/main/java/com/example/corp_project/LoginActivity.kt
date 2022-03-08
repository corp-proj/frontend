package com.example.corp_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.corp_project.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        //액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            View.OnClickListener {
                Toast.makeText(this@LoginActivity, "오늘은 어떤 뉴스를 보실까요?", Toast.LENGTH_SHORT).show()
                val intent = Intent()
                startActivity(intent)
                finish()
            }
        }
    }
}