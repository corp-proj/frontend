package com.example.corp_project

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.corp_project.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var detailBinding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        val view = detailBinding.root
        setContentView(view)


        detailBinding.icBackspace.setOnClickListener {
            val back = Intent(this,MainActivity::class.java)
            startActivity(back)
        }



    }


}