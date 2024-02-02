package com.example.gurudiary

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import java.util.Date

class DiaryActivity : AppCompatActivity() {

    private lateinit var title_editText: EditText
    private lateinit var memo_editText: EditText

    private lateinit var okbutton: Button
    private lateinit var date: TextView
    private lateinit var calendarView: CalendarView

    private lateinit var wtIcon: ImageView
    private var currentImageIndex = 0
    private val imageResources = arrayOf(
        R.drawable.rain,
        R.drawable.cloud,
        R.drawable.snow,
        R.drawable.sun
    )


    private lateinit var pageLayout: LinearLayout

    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        title_editText = findViewById(R.id.title_editText)
        memo_editText = findViewById(R.id.memo_editText)
        okbutton = findViewById(R.id.okbutton)
        date = findViewById(R.id.date)
        calendarView = findViewById(R.id.calendarView)
        wtIcon = findViewById(R.id.wt_icon)
        //pageLayout = findViewById(R.id.page)


        var year = intent.getIntExtra("year",0)
        var month = intent.getIntExtra("month",0)
        var dayOfMonth = intent.getIntExtra("day",0)
        val dateText = "${year}년 ${month + 1}월 ${dayOfMonth}일"
        date.text = dateText
        val filename = "${year}-${month + 1}-${dayOfMonth}"

        // 날씨 아이콘 변경
        val leftWtButton: Button = findViewById(R.id.leftwt)
        val rightWtButton: Button = findViewById(R.id.rightwt)

        leftWtButton.setOnClickListener {
            currentImageIndex = (currentImageIndex - 1 + imageResources.size) % imageResources.size
            updateWtIconImage()
        }

        rightWtButton.setOnClickListener {
            currentImageIndex = (currentImageIndex + 1) % imageResources.size
            updateWtIconImage()
        }

        // 이미지를 선택하는 Intent를 처리할 버튼 클릭 리스너 설정
        val uploadButton: Button = findViewById(R.id.upload)
        uploadButton.setOnClickListener {
            openGallery()
        }

        // 기존 코드 유지
        okbutton.setOnClickListener {

            saveToInternalStorage(filename,memo_editText.text.toString())
        }



        var tab1Button: Button = findViewById(R.id.logout)
        var tab2Button: Button = findViewById(R.id.main)
        var tab3Button: Button = findViewById(R.id.list)


        tab1Button.setOnClickListener {
            // tab1 클릭 시 동작
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        tab2Button.setOnClickListener {
            // tab2 클릭 시 동작

            val intent = Intent(this, CalenderActivity::class.java)
            startActivity(intent)
        }

        tab3Button.setOnClickListener {
            // tab3 클릭 시 동작

            val intent = Intent(this, DiaryListActivity::class.java)
            startActivity(intent)

        }


    }

    private fun updateWtIconImage() {
        wtIcon.setImageResource(imageResources[currentImageIndex])
    }

    fun saveToInternalStorage(name : String, content: String) {
        val filename = name + ".text"
        val fileContent = content
        val fos : FileOutputStream

        try {

            fos = openFileOutput(filename, MODE_PRIVATE)
            fos.write(fileContent.toByteArray())
            Log.d("aaa", "file    "+ fileContent)
            fos.close()

        }catch (e:Exception){
            e.printStackTrace()

        }
    }



    private fun openGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK)
        galleryIntent.type = "image/*"
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            pageLayout.visibility = LinearLayout.VISIBLE
        }
    }
}
