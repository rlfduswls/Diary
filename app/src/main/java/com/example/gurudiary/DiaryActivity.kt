package com.example.gurudiary

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.FileOutputStream

class DiaryActivity : AppCompatActivity() {

    private lateinit var diaryTextView: TextView
    private lateinit var contextEditText: EditText
    private lateinit var textView2: TextView
    private lateinit var confirmButton: Button
    private lateinit var photoImageView: ImageView

    lateinit var btnLogout: Button
    lateinit var btnMain: Button
    lateinit var btnList : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)
        diaryTextView = findViewById(R.id.diaryTextView)
        contextEditText = findViewById(R.id.contextEditText)
        textView2 = findViewById(R.id.textView2)
        confirmButton = findViewById(R.id.confirmButton)
        photoImageView = findViewById(R.id.photoImageView)

        btnLogout.findViewById<Button>(R.id.logout)
        btnList.findViewById<Button>(R.id.list)
        btnMain.findViewById<Button>(R.id.main)

        // 기존 코드 유지

        confirmButton.setOnClickListener {
            saveToInternalStorage(textView2.text.toString())
        }

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

    private fun saveToInternalStorage(content: String) {
        val fileName = "diary_content.txt" // 파일 이름을 원하는 대로 설정
        val fos: FileOutputStream

        try {
            fos = openFileOutput(fileName, MODE_PRIVATE)
            fos.write(content.toByteArray())
            fos.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private val PICK_IMAGE_REQUEST = 1

    // 갤러리 열기
    private fun openGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
    }

    // 갤러리에서 이미지를 선택한 결과 처리
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri: Uri = data.data!!

            // 이미지를 ImageView에 설정
            photoImageView.setImageURI(selectedImageUri)
        }
    }

}