package com.example.corp_project

import java.io.Serializable

data class News(
    val imgUrl: String,
    val text: String,
    val title: String,
    val url: String
):Serializable