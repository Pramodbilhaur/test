package com.pramod

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.*
import model.Pro
import network.ApiInterfaces
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class SecondActivity :AppCompatActivity()
{
    lateinit var textView: TextView

    lateinit var switch1: Switch
    lateinit var next: Button
    lateinit var dob: EditText
    lateinit var stringY: String
    lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout)

        val calendar= Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val message = intent.getStringExtra("message")
        val password = intent.getStringExtra("password")
        textView = findViewById<EditText>(R.id.textView)
        switch1 = findViewById<Switch>(R.id.switch1)
       recyclerView = findViewById(R.id.recycle)
        next = findViewById<Button>(R.id.next)
        dob = findViewById<EditText>(R.id.dob)

        switch1.setOnCheckedChangeListener{ _, isChecked ->

            if (isChecked) {
                // The switch enabled

                dob.visibility = View.VISIBLE
                next.visibility = View.VISIBLE

            } else {
                // The switch disabled
                dob.visibility = View.GONE
                next.visibility = View.GONE
            }

        }

        dob.setOnClickListener{

            val datePickerDialog = DatePickerDialog(this@SecondActivity, DatePickerDialog.OnDateSetListener
            { view, year, monthOfYear, dayOfMonth ->

                val msg=  "" + dayOfMonth + " - " + (monthOfYear+1) + " - " + year
                dob.setText(msg)
                Toast.makeText(this@SecondActivity, msg, Toast.LENGTH_LONG).show()

            }, year, month, day)

            datePickerDialog.show()
        }
        textView.text="Hi, Wlcome : "+message +" Password: "+password
        next.setOnClickListener {

            stringY =dob.text.toString()

            val intent = Intent(this, ThirdActivity::class.java).apply {

                putExtra("birth_year", stringY)
            }
            startActivity(intent)
        }


        val apiInterface = ApiInterfaces.create().getProduct()

        apiInterface.enqueue( object : Callback<Pro>{

            override fun onResponse(call:Call<Pro>?, response: Response<Pro>?)
            {
                Log.d("getValues","-->");
                if(response?.body() != null)
                {


                    val adapter = MyAdapter( response.body()!!.data)

                    recyclerView.layoutManager = LinearLayoutManager(this@SecondActivity)
                    recyclerView.adapter = adapter

                    var sr : String
                    sr=""
                    for(item in response.body()!!.data)
                    {
                        sr += ", \n "+item.name

                    }
                    textView.text=sr
                    Log.d("getValues","-->"+response.body()!!.data.get(5).year);
                }
            }

            override fun onFailure(call: Call<Pro>?, t: Throwable?) {
                Log.d("getValues","--"+t.toString());
            }
        })
    }
    override fun onStop()
    {
        super.onStop()
        finish()
    }
    override fun onPause()
    {
        super.onPause()
        Toast.makeText(this, "PAUSE", Toast.LENGTH_SHORT).show()
    }
}