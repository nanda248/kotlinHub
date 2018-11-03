package com.example.nanda.kotlinhub.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.nanda.kotlinhub.R

class ActivityFunction : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function)

        val btnFun = findViewById<Button>(R.id.btn_topic13)
        val btnInfix = findViewById<Button>(R.id.btn_topic14)
        val btnRecursion = findViewById<Button>(R.id.btn_topic15)

        btnFun.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_13")
            myIntent.putExtra("topicNum", 13)
            startActivity(myIntent)
        }

        btnInfix.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_14")
            myIntent.putExtra("topicNum", 14)
            startActivity(myIntent)
        }

        btnRecursion.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_15")
            myIntent.putExtra("topicNum", 15)
            startActivity(myIntent)
        }
    }
}
