package com.example.jokeshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class JokeActivity : AppCompatActivity() {
var joketext:String?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        jokef()
        val name=intent.getStringExtra("name")
        val name1=findViewById<TextView>(R.id.name).setText("hey! $name a Joke for you...")
        val next=findViewById<Button>(R.id.next)
        val share=findViewById<Button>(R.id.share)
        next.setOnClickListener{
            jokef()
        }
        share.setOnClickListener{
            val intent=Intent(Intent.ACTION_SEND)
            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,"$joketext")
            startActivity(Intent.createChooser(intent,"Share Vai"))
        }

    }



    private fun jokef() {
        val pro=findViewById<ProgressBar>(R.id.pro)
        pro.visibility=View.VISIBLE
        var requestQueue: RequestQueue = Volley.newRequestQueue(this)
        val url = "https://official-joke-api.appspot.com/random_joke"
        val request = JsonObjectRequest(
            Request.Method.GET, url,null,
            { response ->

                val joke1=response.getString("setup")
                val joke2=response.getString("punchline")
                 joketext="$joke1\n$joke2"
                var joke= findViewById<TextView>(R.id.eee)
                pro.visibility=View.GONE
                joke.setText(joketext)

            },
            { error ->
                var joke= findViewById<TextView>(R.id.eee)
                joke.setText(getString(R.string.error))
            })

        requestQueue.add(request)
    }

}