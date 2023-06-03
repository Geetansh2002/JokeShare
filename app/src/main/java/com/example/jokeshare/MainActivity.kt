package com.example.jokeshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start=findViewById<Button>(R.id.startbutton)

        start.setOnClickListener{
            val name=findViewById<EditText>(R.id.name).editableText.toString()
            val intent=Intent(this,JokeActivity::class.java)
            intent.putExtra("name",name)
            startActivity(intent)
        }
    }
}