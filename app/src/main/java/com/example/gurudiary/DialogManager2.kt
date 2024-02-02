package com.example.gurudiary

import android.app.Dialog
import android.content.Context
import android.widget.Button

class DialogManager2(context: Context) {
    private val dialog = Dialog(context)

    fun showDig() {


        dialog.setContentView(R.layout.dialog2)
        dialog.setCanceledOnTouchOutside(true)


        dialog.show()

    }

}