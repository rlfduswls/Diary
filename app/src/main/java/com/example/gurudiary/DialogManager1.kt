package com.example.gurudiary

import android.app.Dialog
import android.content.Context
import android.widget.Button

class DialogManager1 (context: Context){

    private val dialog = Dialog(context)

    fun showDig() {


        dialog.setContentView(R.layout.dialog1)
        dialog.setCanceledOnTouchOutside(true)

        dialog.show()

    }


}