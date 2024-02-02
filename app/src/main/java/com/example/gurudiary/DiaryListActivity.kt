package com.example.gurudiary

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class DiaryListActivity : AppCompatActivity() {

    lateinit var title1: TextView
    lateinit var memo1: TextView
    lateinit var title2: TextView
    lateinit var memo2: TextView
    lateinit var title3: TextView
    lateinit var memo3: TextView
    //다이어리 목록

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_list)


        title1 = findViewById(R.id.title1)
        memo1 = findViewById(R.id.memo1)
        title2 = findViewById(R.id.title2)
        memo2 = findViewById(R.id.memo2)
        title3 = findViewById(R.id.title3)
        memo3 = findViewById(R.id.memo3)


        var tab1Button: Button = findViewById(R.id.logout)
        var tab2Button: Button = findViewById(R.id.main)
        var tab3Button: Button = findViewById(R.id.list)

        viewListOfFiles()


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

    private fun viewListOfFiles() {
        val files: Array<String> = fileList()

        var index: Int = 0
        Log.d("aaa", files.toString())
        for (filename in files) {

            val fileContents = readFileContents(filename)
            when (index) {
                0 -> {
                    title1.text = filename
                    memo1.text = fileContents
                }

                1 -> {

                    title2.text = filename
                    memo2.text = fileContents

                }

                2 -> {
                    title3.text = filename
                    memo3.text = fileContents

                }
            }
            index += 1
            Log.d("aaa", "index    " + index)

            Log.d("aaa", "filename    " + filename)

        }
    }

    private fun readFileContents(filename: String): String {
        val inputStream: FileInputStream = openFileInput(filename)
        val inputStreamReader = InputStreamReader(inputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder = StringBuilder()
        var text: String?

        while (bufferedReader.readLine().also { text = it } != null) {
            stringBuilder.append(text).append("\n")
        }

        bufferedReader.close()
        return stringBuilder.toString()
    }
}