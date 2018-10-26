package com.example.nanda.kotlinhub.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.nanda.kotlinhub.R

class user_home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)

        val btnTest = findViewById<Button>(R.id.btn_test)
        btnTest.setOnClickListener{
            val myIntent = Intent(this, ActivityHomePage::class.java)
            startActivity(myIntent)
        }
    }
}
