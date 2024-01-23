package com.example.gurudiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class JoinMemberActivity : AppCompatActivity() {

    //회원 가입 페이지 제작 위한 액티비티

    lateinit var name: EditText
    lateinit var id: EditText
    lateinit var idCheck : Button
    lateinit var pass: EditText
    lateinit var passCheck : EditText
    lateinit var tel: EditText // 뷰에서 받아올 정보들
    //이 정보들을 db로 업데이트 할 예정입니다
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_member)

        name = findViewById(R.id.name)
        id = findViewById(R.id.userId)
        idCheck = findViewById(R.id.CheckId)
        pass = findViewById(R.id.pass)
        passCheck = findViewById(R.id.passCheck)
        tel = findViewById(R.id.tel)

    }

    //아이디 중복 확인 버튼을 눌렀을 때 중복인지 아닌지 확인하는 기능

    //제출버튼을 눌렀을 때 DB에 추가하는 기능...

    //일단디비를불러올게요
    //디비이름머로할까요

}