package com.example.nanda.kotlinhub.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.nanda.kotlinhub.R
import com.example.nanda.kotlinhub.helper.UserDBHelper

class ActivityProfilePage : AppCompatActivity() {

    lateinit var userDBHelper: UserDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        userDBHelper = UserDBHelper(this)

        val username = userDBHelper.getUsername()

        val btnResource = findViewById<Button>(R.id.btn_resource)
        btnResource.setOnClickListener{
            val myIntent = Intent(this, ActivityResource::class.java)
            startActivity(myIntent)
        }

        val btnLogout = findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            userDBHelper.logoutUser(username)
            startActivity(myIntent)
        }

        val btnLesson = findViewById<ImageButton>(R.id.btn_lesson_page)
        btnLesson.setOnClickListener {
            val myIntent = Intent(this, ActivityHomePage::class.java)
            startActivity(myIntent)
        }

        val tv_name_field = findViewById<TextView>(R.id.tv_name_field)
        val name_field_str = "Name: " + username.toString()
        tv_name_field.setText(name_field_str)

        val tv_progress = findViewById<TextView>(R.id.tv_progress)
        val progress = userDBHelper.getProgress()
        val progress_str = "Progress: " + progress.toString()
        tv_progress.setText(progress_str)

        val tv_email_field = findViewById<TextView>(R.id.tv_email_field)
        val email = userDBHelper.getEmail()
        val email_str = "Email: " + email.toString()
        tv_email_field.setText(email_str)


        val btnQuiz = findViewById<Button>(R.id.btn_quiz)
        btnQuiz.setOnClickListener {
            val myIntent = Intent(this, ActivityQuizList::class.java)
            startActivity(myIntent)
        }

        val btnLessonPage = findViewById<ImageButton>(R.id.btn_lesson_page)
        btnLessonPage.setOnClickListener {
            val myIntent = Intent(this, ActivityHomePage::class.java)
            startActivity(myIntent)
        }
    }
}
