package com.example.gurudiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    lateinit var id: EditText
    lateinit var pass: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //메인 액티비티를 첫 화면으로 해서 로그인 액티비티로 만들까 싶어요
        //스크롤 액티비티로 다이어리 화면을 만드시면 될 것 같습니다.
        //메뉴 추가해서 회원가입 페이지로 들어갈 수 있게 할까요 아니면 버튼을 따로 만들까요?

        //아이디와 같은 회원정보 조회하는 코드 사용
        //

    }
}