package com.example.gurudiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class JoinMemberActivity : AppCompatActivity() {

    //회원 가입 페이지 제작 위한 액티비티

    lateinit var dbMember: DBManager
    lateinit var name: EditText
    lateinit var id: EditText
    lateinit var idCheck : Button
    lateinit var pass: EditText
    lateinit var passCheck : EditText
    lateinit var tel: EditText
    lateinit var submit: Button // 뷰에서 받아올 정보들
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
        submit = findViewById(R.id.submit)

        dbMember = DBManager(this, "member", null,1)//회원관리용 db 생성

        submit.setOnClickListener {
            var str_name : String = name.text.toString()
            var str_id : String = id.text.toString()
            var str_pass : String = pass.text.toString()
            var str_tel : String = tel.text.toString()

            //EditText에서 받아온 정보를 memberDB에 넣어주는 작업

            //제출버튼을 눌렀을 때 DB에 추가하는 기능...
        }



    }

    //일단디비를불러올게요
    //회원 관리 DB 이름은 member입니다

    //아이디 중복 검사 함수 !! 아이디가 DB에 존재하면, 토스트 메시지를 띄웁니다.

}