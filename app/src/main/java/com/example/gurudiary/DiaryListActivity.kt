package com.example.gurudiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DiaryListActivity : AppCompatActivity() {

    //다이어리 목록

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_list)

        var tab1Button: Button = findViewById(R.id.logout)
        var tab2Button: Button = findViewById(R.id.main)
        var tab3Button: Button = findViewById(R.id.list)

        tab1Button.setOnClickListener {
            // tab1 클릭 시 동작
            val intent = Intent(this@DiaryListActivity, MainActivity::class.java)
            startActivity(intent)

        }

        tab2Button.setOnClickListener {
            // tab2 클릭 시 동작

            val intent = Intent(this@DiaryListActivity, CalenderActivity::class.java)
            startActivity(intent)
        }

        tab3Button.setOnClickListener {
            // tab3 클릭 시 동작

            val intent = Intent(this@DiaryListActivity, DiaryListActivity::class.java)
            startActivity(intent)

        }
    }
}