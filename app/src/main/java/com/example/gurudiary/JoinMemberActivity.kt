package com.example.gurudiary

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class JoinMemberActivity : AppCompatActivity() {

    //회원 가입 페이지 제작 위한 액티비티

    lateinit var dbMember: DBManager
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var name: EditText
    lateinit var id: EditText
    lateinit var idCheck : Button
    lateinit var pass: EditText
    lateinit var tel: EditText
    lateinit var submit: Button
    lateinit var dlg1:DialogManager1
    lateinit var dlg2:DialogManager2
    lateinit var dlg3:DialogManager3

    // 뷰에서 받아올 정보들
    //이 정보들을 db로 업데이트 할 예정입니다
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_member)

        name = findViewById(R.id.name)
        id = findViewById(R.id.userId)
        idCheck = findViewById(R.id.CheckId)
        pass = findViewById(R.id.pass)
        tel = findViewById(R.id.tel)
        submit = findViewById(R.id.submit)

        dbMember = DBManager(this, "member", null,1)//회원관리용 db 생성

        dlg1 = DialogManager1(this)
        dlg2 = DialogManager2(this)
        dlg3 = DialogManager3(this)



        idCheck.setOnClickListener {
            //아이디 중복 확인 버튼을 눌렀을 때
            var str_id : String = id.text.toString()
            var res = dbMember.checkUser(str_id) //해당 id가 존재하면 true를 반환하는 함수

            if(res){
                dlg2.showDig()
                Toast.makeText(this,"이미 존재하는 아이디입니다.",Toast.LENGTH_SHORT).show()
            }

            else{
                dlg1.showDig()
                Toast.makeText(this,"중복되지 않는 아이디입니다.",Toast.LENGTH_SHORT).show()
            }
        }

        submit.setOnClickListener {
            var str_name : String = name.text.toString()
            var str_id : String = id.text.toString()
            var str_pass : String = pass.text.toString()
            var str_tel : String = tel.text.toString()

            if(str_name==""||str_id==""||str_pass==""||str_tel=="")
            {
                dlg3.showDig()
                Toast.makeText(this,"회원 정보를 모두 입력해주세요.",Toast.LENGTH_SHORT).show()
            }

            else{
                val join = dbMember.insertData(str_id,str_name,str_pass,str_tel) //회원 정보를 insert 합니다
                if(join)
                {
                    Toast.makeText(this,"가입 완료!",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"문제가 발생했습니다. 다시 시도해보세요.",Toast.LENGTH_SHORT).show()
                }
            }
        }



    }

}