package com.example.sd_raw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name :EditText=findViewById(R.id.etname)
        val cgpa :EditText=findViewById(R.id.etcgpa)
        val save:Button=findViewById(R.id.btsave)
        val load:Button=findViewById(R.id.btload)
        save.setOnClickListener {
            val n1=name.text.toString()
            val grade=cgpa.text.toString()
            val file=File(getExternalFilesDir(null),"student.txt")
            val fos=FileOutputStream(file,false)
            fos.write("$n1,$grade".toByteArray())
            fos.close()
            name.setText("")
            cgpa.setText("")
        }
        load.setOnClickListener {
            val file=File(getExternalFilesDir(null),"student.txt")
            val fis=FileInputStream(file)
            val isr= InputStreamReader(fis)
            val br=BufferedReader(isr)
            val line:String
            line=br.readLine()
            var part=line.split(",")
            name.setText(part[0])
            cgpa.setText(part[1])
            fis.close()
        }
    }
}
