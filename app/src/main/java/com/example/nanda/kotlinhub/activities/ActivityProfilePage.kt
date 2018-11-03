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

        val btnLogout = findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            userDBHelper.logoutUser(username)
            startActivity(myIntent)
        }

        val tv_progress = findViewById<TextView>(R.id.tv_progress)
        val progress = userDBHelper.getProgress(username)
        val str = "Progress: " + progress.toString()
        tv_progress.setText(str)

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
