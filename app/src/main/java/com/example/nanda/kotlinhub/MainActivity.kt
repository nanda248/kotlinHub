package com.example.nanda.kotlinhub

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogIn = findViewById<Button>(R.id.btn_login)
        btnLogIn.setOnClickListener {
            addUser()
            val myIntent = Intent(this, MainPage::class.java)
            startActivity(myIntent)
        }
    }

    fun addUser() {
        var username = this.et_username.text.toString()
        var email = this.et_email.text.toString()
        var password = this.et_password.text.toString()


    }
}
