package com.example.gurudiary

import android.content.Context
import java.io.File

class FileManager {


    private lateinit var context: Context

    fun accessStoredFile(name : String): File {
        val dir = context.filesDir
        val filename = name+".text"
        val file = File(dir, filename)
        return file
    }

    // Stream 사용해서 파일 저장하기
    fun saveToInternalStorage(name : String, content: String) {
        val filename = name + ".text"
        val fileContent = content
        // API 24 이상에서, MODE_PRIVATE 사용 안하면, SecurityException 발생
        context.openFileOutput(filename, Context.MODE_PRIVATE).use {
            it.write(fileContent.toByteArray())
        }
    }

    // Stream 사용해서 파일 접근하기
    fun accessFileUsingStream(name : String) {
        val filename = name+".text"
        context.openFileInput(filename).bufferedReader().useLines { lines ->
            lines.fold("") { some, text ->
                "$some\n$text"
            }
        }
    }

    // 파일 리스트 받아오기
    fun viewListOfFiles() {
        var files: Array<String> = context.fileList()
    }

}