package com.example.gurudiary

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


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

        dbMember = DBManager(this, "member", null,1)//회원관리용 db 생성
        loginSubmit = findViewById(R.id.loginsubmit)
        joinSubmit = findViewById(R.id.joinsubmit)
        id = findViewById(R.id.userId)
        pass = findViewById(R.id.pass)
        loginSubmit.setOnClickListener {


            var str_id = id.text.toString()
            var str_pass = pass.text.toString()

            var checkID = dbMember.checkUser(str_id) //아이디가 DB에 존재하는지 확인합니다.

            if(!checkID)
            //예외처리 필요합니다. 어떻게 구현할지 고민중이에요~
            {
                Toast.makeText(this,"존재하지 않는 ID입니다.", Toast.LENGTH_SHORT).show()
            }

            else{

                var checkPass = dbMember.checkPass(str_id,str_pass)
                if(!checkPass)
                {
                    Toast.makeText(this,"비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(this,"로그인 성공.", Toast.LENGTH_SHORT).show()
                }

            }

        } //여기까지 로그인 버튼

        joinSubmit.setOnClickListener {
            val intent = Intent(this, JoinMemberActivity::class.java)
            startActivity(intent)
            //회원가입 페이지로 이동합니다.

        }



    }
}