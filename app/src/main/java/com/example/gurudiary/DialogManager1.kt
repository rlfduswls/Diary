package com.example.gurudiary

import android.app.Dialog
import android.content.Context
import android.widget.Button

class DialogManager1 (context: Context){

    private val dialog = Dialog(context)
    lateinit var btnOK : Button


    fun showDig() {


        dialog.setContentView(R.layout.dialog1)
        dialog.setCanceledOnTouchOutside(true)

        btnOK.findViewById<Button>(R.id.btnConfirm)

        dialog.show()

        btnOK.setOnClickListener {
            dialog.dismiss()
        }
    }


}