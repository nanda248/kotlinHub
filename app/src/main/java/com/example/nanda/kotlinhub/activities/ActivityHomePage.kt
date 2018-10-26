package com.example.nanda.kotlinhub.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton
import com.example.nanda.kotlinhub.R

class ActivityHomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val btnBasicConcept = findViewById<ImageButton>(R.id.btn_basic_concept)
        val btnCO = findViewById<ImageButton>(R.id.btn_class_object)
        val btnFun = findViewById<ImageButton>(R.id.btn_function)
        val btnMiscell = findViewById<ImageButton>(R.id.btn_miscellaneous)

        btnBasicConcept.setOnClickListener {
            val myIntent = Intent(this, ActivityBasicConcepts::class.java)
            startActivity(myIntent)
        }

    }
}
