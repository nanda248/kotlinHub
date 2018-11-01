package com.example.nanda.kotlinhub.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.nanda.kotlinhub.R
import com.example.nanda.kotlinhub.helper.UserDBHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var userDBHelper: UserDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val btnLogIn = findViewById<Button>(R.id.btn_login)
//        btnLogIn.setOnClickListener {
//            addUser()
//            val myIntent = Intent(this, MainPage::class.java)
//            startActivity(myIntent)
//        }

        val goToRegisterPage = findViewById<TextView>(R.id.registerNewAccount)
        goToRegisterPage.setOnClickListener {
            val myIntent = Intent(this, register::class.java)
            startActivity(myIntent)
        }

        val btnLogIn = findViewById<Button>(R.id.btn_login)
        btnLogIn.setOnClickListener {
            var email = this.et_login_email.text.toString()
            var password = this.et_login_password.text.toString()
            var result = userDBHelper.loginUser(email, password)
            if(result == true) {
                val myIntent = Intent(this, ActivityHomePage::class.java)
                startActivity(myIntent)
            } else {
                Toast.makeText(this, "Invalid Email or Password.", Toast.LENGTH_LONG).show()
            }
        }

        val goToManageUserPage = findViewById<TextView>(R.id.manageUserAccounts)
        goToManageUserPage.setOnClickListener {
            val myIntent = Intent(this, manage_user::class.java)
            startActivity(myIntent)
        }

        userDBHelper = UserDBHelper(this)
    }

//    fun addUser() {
//        var username = this.et_username.text.toString()
//        var email = this.et_email.text.toString()
//        var password = this.et_password.text.toString()
//        println("THIS IS IN ADDUSER")
//        if(::userDBHelper.isInitialized) {
//            println("INITIALIZED")
//        }else {
//            println("NOT INITIALIZED")
//        }
//        var result = userDBHelper.loginUser(UserDataRecord(username, 0, email, password, true))
//    }
}
