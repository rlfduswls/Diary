package com.example.gurudiary

import android.app.Dialog
import android.content.Context
import android.widget.Button

class DialogManager3(context: Context) {

    private val dialog = Dialog(context)
    fun showDig() {


        dialog.setContentView(R.layout.dialog3)
        dialog.setCanceledOnTouchOutside(true)

        dialog.show()

    }

}