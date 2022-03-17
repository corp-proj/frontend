package com.example.corp_project
import com.google.gson.annotations.SerializedName

data class Detail(
    @SerializedName("data")
    val `data`: List<Any>,
    @SerializedName("summarized")
    val summarized: List<String>
)