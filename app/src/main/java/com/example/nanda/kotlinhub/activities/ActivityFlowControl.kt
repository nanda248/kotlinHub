package com.example.nanda.kotlinhub.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.nanda.kotlinhub.R

class ActivityFlowControl : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow_control)

        val btnIf = findViewById<Button>(R.id.btn_topic7)
        val btnWhen = findViewById<Button>(R.id.btn_topic8)
        val btnWhile = findViewById<Button>(R.id.btn_topic9)
        val btnFor = findViewById<Button>(R.id.btn_topic10)
        val btnBreak = findViewById<Button>(R.id.btn_topic11)
        val btnContinue = findViewById<Button>(R.id.btn_topic12)

        btnIf.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_7")
            myIntent.putExtra("topicNum", 7)
            startActivity(myIntent)
        }

        btnWhen.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_8")
            myIntent.putExtra("topicNum", 8)
            startActivity(myIntent)
        }

        btnWhile.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_9")
            myIntent.putExtra("topicNum", 9)
            startActivity(myIntent)
        }

        btnFor.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_10")
            myIntent.putExtra("topicNum", 10)
            startActivity(myIntent)
        }

        btnBreak.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_11")
            myIntent.putExtra("topicNum", 11)
            startActivity(myIntent)
        }

        btnContinue.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_12")
            myIntent.putExtra("topicNum", 12)
            startActivity(myIntent)
        }

    }
}
