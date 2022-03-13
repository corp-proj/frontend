package com.example.corp_project

import android.widget.EditText
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserInfo(
    @PrimaryKey val pkId: Int?,
    @ColumnInfo val email: String?,
    @ColumnInfo val pw: String
)