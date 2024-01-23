package com.example.gurudiary


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//회원 관리용 DB를 만드는 클래스입니다.
class DBManager(context:Context,
                name:String,
                factory:SQLiteDatabase.CursorFactory?,
                version:Int):SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE member(name text, id text, pass text, tel text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}