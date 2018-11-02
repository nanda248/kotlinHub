package com.example.nanda.kotlinhub.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.nanda.kotlinhub.R

class ActivityBasicConcepts : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_concepts)

        val btnOverview = findViewById<Button>(R.id.btn_topic1)
        val btnBasicType = findViewById<Button>(R.id.btn_topic2)
        val btnOperators = findViewById<Button>(R.id.btn_topic3)
        val btnTypeConvertion = findViewById<Button>(R.id.btn_topic4)
        val btnES = findViewById<Button>(R.id.btn_topic5)

        btnOverview.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_1")
            startActivity(myIntent)
        }

        btnBasicType.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_2")
            startActivity(myIntent)
        }


    }
}
