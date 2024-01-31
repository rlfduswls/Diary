package com.example.gurudiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DiaryListActivity : AppCompatActivity() {

    lateinit var btnLogout: Button
    lateinit var btnMain: Button
    lateinit var btnList : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_list)

        btnLogout.findViewById<Button>(R.id.logout)
        btnList.findViewById<Button>(R.id.list)
        btnMain.findViewById<Button>(R.id.main)

        btnLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnMain.setOnClickListener {
            val intent = Intent(this, DiaryListActivity::class.java)
            startActivity(intent)
        }

        btnList.setOnClickListener {
            val intent = Intent(this, DiaryListActivity::class.java)
            startActivity(intent)
        }
    }
}