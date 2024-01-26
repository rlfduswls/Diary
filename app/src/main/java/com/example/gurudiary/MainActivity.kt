package com.example.gurudiary

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {


    lateinit var dbMember: DBManager
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var id: EditText
    lateinit var pass: EditText
    lateinit var loginSubmit : Button
    lateinit var joinSubmit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loginSubmit.setOnClickListener {


        }

    }
}