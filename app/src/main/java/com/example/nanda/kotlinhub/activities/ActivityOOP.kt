package com.example.nanda.kotlinhub.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.nanda.kotlinhub.R

class ActivityOOP : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oop)

        val btnCO = findViewById<Button>(R.id.btn_topic16)
        val btnConstructor = findViewById<Button>(R.id.btn_topic17)
        val btnInheritance = findViewById<Button>(R.id.btn_topic18)
        val btnAbstract = findViewById<Button>(R.id.btn_topic19)
        val btnInterface = findViewById<Button>(R.id.btn_topic20)
        val btnData = findViewById<Button>(R.id.btn_topic21)
        val btnSealed = findViewById<Button>(R.id.btn_topic22)
        val btnCompanion = findViewById<Button>(R.id.btn_topic23)

        btnCO.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_16")
            myIntent.putExtra("topicNum", 16)
            startActivity(myIntent)
        }

        btnConstructor.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_17")
            myIntent.putExtra("topicNum", 17)
            startActivity(myIntent)
        }

        btnInheritance.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_18")
            myIntent.putExtra("topicNum", 18)
            startActivity(myIntent)
        }

        btnAbstract.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_19")
            myIntent.putExtra("topicNum", 19)
            startActivity(myIntent)
        }

        btnInterface.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_20")
            myIntent.putExtra("topicNum", 20)
            startActivity(myIntent)
        }

        btnData.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_21")
            myIntent.putExtra("topicNum", 21)
            startActivity(myIntent)
        }

        btnSealed.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_22")
            myIntent.putExtra("topicNum", 22)
            startActivity(myIntent)
        }

        btnCompanion.setOnClickListener {
            val myIntent = Intent(this, ActivityTopic()::class.java)
            myIntent.putExtra("topicFile", "topic_23")
            myIntent.putExtra("topicNum", 23)
            startActivity(myIntent)
        }

    }
}
