package com.example.gurudiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import java.io.FileInputStream
import java.io.FileOutputStream
import android.content.Intent
import com.example.gurudiary.DiaryActivity
import com.example.gurudiary.R



class CalenderActivity : AppCompatActivity() {

    private var fname: String? = null
    private var str: String? = null
    private lateinit var calendarView: CalendarView
    private lateinit var cha_Btn: Button
    private lateinit var del_Btn: Button
    private lateinit var save_Btn: Button
    private lateinit var diaryTextView: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var contextEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)

        calendarView = findViewById(R.id.calendarView)


        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val intent = Intent(this@CalenderActivity, DiaryActivity::class.java)
            intent.putExtra("year", year)
            intent.putExtra("month", month)
            intent.putExtra("day", dayOfMonth)
            //intent.putExtra("userID", userID) // 이전 액티비티에서 받아온 userID를 전달
            startActivity(intent)
        }

/**
        val tab1Button: Button = findViewById(R.id.tab1)
        val tab2Button: Button = findViewById(R.id.tab2)
        val tab3Button: Button = findViewById(R.id.tab3)

        tab1Button.setOnClickListener {
            // tab1 클릭 시 동작
        }

        tab2Button.setOnClickListener {
            // tab2 클릭 시 동작
        }

        tab3Button.setOnClickListener {
            // tab3 클릭 시 동작
            tab3Button.setOnClickListener {
                val intent = Intent(this@CalenderActivity, DiaryActivity::class.java)
                startActivity(intent)
            }
        }
**/

    }
}