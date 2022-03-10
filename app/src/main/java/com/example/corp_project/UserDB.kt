package com.example.corp_project

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserInfo::class], version = 1)
//룸데이터베이스 확장하는 추상클래스
abstract class UserDB: RoomDatabase() {
    abstract fun getDao() : UserDao

    companion object{
        private var instance : UserDB? = null

        @Synchronized
        fun getInstance(context: Context) : UserDB? {
            if(instance == null){
                synchronized(UserDB::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDB::class.java,
                        "user.db"
                    ).build()
                }
            }
            return instance
        }
    }
}