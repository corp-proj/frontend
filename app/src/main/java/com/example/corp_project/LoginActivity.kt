package com.example.corp_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.corp_project.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var db: UserDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email: EditText = findViewById(R.id.email)
        val password: EditText = findViewById(R.id.password)
        val button: Button = findViewById(R.id.button)

        //db생성
        db = Room.databaseBuilder(this, UserDB::class.java, "UserDB").allowMainThreadQueries()
            .build()

        button.setOnClickListener(View.OnClickListener() {
            if (email.text.isNotEmpty() && password.text.isNotEmpty()) {
                joinUser()
                if (checkValidPw(email.text.toString()) == password.text.toString()) {
                        Toast.makeText(this, "어떤 뉴스를 좋아하세요?",Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,TagActivity::class.java)
                        startActivity(intent)
                }
                else {
                    Toast.makeText(this, "아이디와 비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "아이디와 비밀번호는 필수 입력 사항입니다.",Toast.LENGTH_SHORT).show()
            }
        })
    }

    //email, pw 들어오면 값 저장
    private fun joinUser() {
        val email : EditText = findViewById(R.id.email)
        val password : EditText = findViewById(R.id.password)
        val pkId = db.getDao().getEmail().size + 1
        db.getDao().insertUser(UserInfo(pkId, email.text.toString(), password.text.toString()))
    }

    private fun checkValidPw(email: String): String {
        return db.getDao().getEmailByPw(email)
    }
}