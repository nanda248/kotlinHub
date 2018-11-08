package com.example.nanda.kotlinhub.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.nanda.kotlinhub.R

class ActivityQuizList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_list)

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        val btn1 = findViewById<Button>(R.id.btn_quiz1)
        val btn2 = findViewById<Button>(R.id.btn_quiz2)
        val btn3 = findViewById<Button>(R.id.btn_quiz3)
        val btn5 = findViewById<Button>(R.id.btn_quiz5)
        val btn7 = findViewById<Button>(R.id.btn_quiz7)
        val btn8 = findViewById<Button>(R.id.btn_quiz8)
        val btn9 = findViewById<Button>(R.id.btn_quiz9)
        val btn10 = findViewById<Button>(R.id.btn_quiz10)
        val btn11 = findViewById<Button>(R.id.btn_quiz11)
        val btn13 = findViewById<Button>(R.id.btn_quiz13)
        val btn14 = findViewById<Button>(R.id.btn_quiz14)
        val btn15 = findViewById<Button>(R.id.btn_quiz15)
        val btn16 = findViewById<Button>(R.id.btn_quiz16)
        val btn17 = findViewById<Button>(R.id.btn_quiz17)
        val btn18 = findViewById<Button>(R.id.btn_quiz18)
        val btn19 = findViewById<Button>(R.id.btn_quiz19)
        val btn20 = findViewById<Button>(R.id.btn_quiz20)
        val btn21 = findViewById<Button>(R.id.btn_quiz21)
        val btn23 = findViewById<Button>(R.id.btn_quiz23)

        btn1.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_1")
            startActivity(myIntent)
        }

        btn2.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_2")
            startActivity(myIntent)
        }

        btn3.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_3")
            startActivity(myIntent)
        }

        btn5.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_5")
            startActivity(myIntent)
        }

        btn7.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_7")
            startActivity(myIntent)
        }

        btn8.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_8")
            startActivity(myIntent)
        }

        btn9.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_9")
            startActivity(myIntent)
        }

        btn10.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_10")
            startActivity(myIntent)
        }

        btn11.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_11")
            startActivity(myIntent)
        }

        btn13.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_13")
            startActivity(myIntent)
        }

        btn14.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_14")
            startActivity(myIntent)
        }

        btn15.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_15")
            startActivity(myIntent)
        }

        btn16.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_16")
            startActivity(myIntent)
        }

        btn17.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_17")
            startActivity(myIntent)
        }

        btn18.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_18")
            startActivity(myIntent)
        }

        btn19.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_19")
            startActivity(myIntent)
        }

        btn20.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_20")
            startActivity(myIntent)
        }

        btn21.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_21")
            startActivity(myIntent)
        }

        btn23.setOnClickListener {
            val myIntent = Intent(this, ActivityQuiz::class.java)
            myIntent.putExtra("quizFile", "quiz_23")
            startActivity(myIntent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }
}
