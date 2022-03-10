package com.example.corp_project

import android.provider.ContactsContract
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
@Dao

interface UserDao {
    //회원가입
    @Insert
    fun insertUser(userInfo: UserInfo)

    //email 찾아서 지우기
    @Query("select email from UserInfo where email = :email")
    fun deleteUserByEmail(email: String): String

    //비밀번호 체크
    @Query("select pw from UserInfo where email = :email")
    fun getEmailByPw(email: String): String

    //가입여부 판단
    @Query("select email from UserInfo")
    fun getEmail(): List<String>
}