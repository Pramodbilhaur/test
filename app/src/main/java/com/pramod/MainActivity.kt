package com.pramod

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class   MainActivity : AppCompatActivity()
{
    lateinit var editTextU: EditText
    lateinit var editTextp: EditText
    lateinit var textt: TextView
    lateinit var fpass: TextView
    lateinit var submit: Button
    lateinit var stringU: String
    lateinit var stringP: String
    lateinit var fuser: TextView



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextU = findViewById<EditText>(R.id.username)
        editTextp =findViewById<EditText>(R.id.password)
        textt =findViewById<TextView>(R.id.textt)
        fpass=findViewById<TextView>(R.id.fpass)
        submit =findViewById<Button>(R.id.submit)
        fuser =findViewById<TextView>(R.id.fuser)

        // fpass.makeHyperLink("https://www.google.com/search?q=android")

        fpass.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.google.com")
            })

        }
        submit.setOnClickListener{

            stringU = editTextU.text.toString()
            stringP =editTextp.text.toString()

            if(stringU.equals("Admin") && stringP.equals("Admin"))
            {
                textt.text="Yeaah welcome!"

                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("message",stringU )
                }
                startActivity(intent)

            }
            else
            {
                textt.text="Yeaah welcome!"

                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("message",stringU )
                }
                startActivity(intent)

//                textt.text ="Please Enter proper password!"
            }

        }

        fuser.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.gmail.com")
            })

        }
    }
}