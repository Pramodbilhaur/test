package com.pramod

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class ThirdActivity : AppCompatActivity ()
{
    lateinit var textp : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_layout)
        textp = findViewById<TextView>(R.id.textp)
        val birth_year = intent.getStringExtra("birth_year")
        textp.text= birth_year

    }
    
}