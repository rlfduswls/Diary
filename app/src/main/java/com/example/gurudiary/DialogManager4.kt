package com.example.gurudiary

import android.app.Dialog
import android.content.Context
import android.widget.Button

class DialogManager4(context: Context) {

    private val dialog = Dialog(context)
    lateinit var btnOK: Button

    fun showDig() {


        dialog.setContentView(R.layout.dialog4)
        dialog.setCanceledOnTouchOutside(true)

        btnOK.findViewById<Button>(R.id.btnConfirm)

        dialog.show()

        btnOK.setOnClickListener {
            dialog.dismiss()
        }
    }

}