package com.example.gurudiary


import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//회원 관리용 DB를 만드는 클래스입니다.
class DBManager(context:Context,
                name:String,
                factory:SQLiteDatabase.CursorFactory?,
                version:Int):SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE member(id text PRIMARY KEY, name text, pass text, tel text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun insertData (id:String?, name:String?,pass:String?,tel:String?): Boolean {
        val DB = this.writableDatabase
        val contentValue = ContentValues()

        contentValue.put("id", id)
        contentValue.put("name", name)
        contentValue.put("pass", pass)
        contentValue.put("tel", tel)

        val result = DB.insert("member",null, contentValue)

        DB.close()
        if(result==-1L)
            return false
        else
            return true
    }


    fun checkUser(id:String?):Boolean {

        val DB = this.writableDatabase
        var result = true

        val cursor = DB.rawQuery("SELECT * FROM member WHERE id= '"+id+"';", null)
        if(cursor.count<=0) result = false
        else result = true

        DB.close()
        return result
    }


    fun checkPass(id:String, pass:String):Boolean {
        val DB = this.writableDatabase
        var result = true

        val cursor = DB.rawQuery("SELECT * FROM member WHERE id= '"+id+"'AND pass= '"+pass + "';", null)
        if(cursor.count<=0) result = false
        else result = true

        DB.close()

        return result

    }


    companion object{
        const val DBNAME = "Login.db"
    }

}