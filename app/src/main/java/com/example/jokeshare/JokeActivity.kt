package com.example.jokeshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class JokeActivity : AppCompatActivity() {
    var joke1: String? =null
    var joke2:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        jokef()
        val name=intent.getStringExtra("name")
        val name1=findViewById<TextView>(R.id.name).setText("hey! $name a Joke for you...")
        val next=findViewById<Button>(R.id.next)
        next.setOnClickListener{
            jokef()
        }


    }


        private fun jokef() {
            var requestQueue: RequestQueue = Volley.newRequestQueue(this)
            val url = "https://official-joke-api.appspot.com/jokes/programming/random"
            val request = JsonObjectRequest(
                Request.Method.GET, url,null,
                { response ->
                    joke1=response.getString("setup")
                    joke2=response.getString("punchline")
                    val joketext="$joke1/n$joke2"
                    var joke= findViewById<TextView>(R.id.eee)
                    joke.setText(joketext)

                },
                { error ->

                })

            requestQueue.add(request)
        }

}