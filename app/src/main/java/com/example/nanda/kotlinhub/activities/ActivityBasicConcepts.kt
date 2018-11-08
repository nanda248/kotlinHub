package com.example.nanda.kotlinhub.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.example.nanda.kotlinhub.R
import com.example.nanda.kotlinhub.helper.UserDBHelper
import kotlinx.android.synthetic.main.activity_home_page.*

class ActivityBasicConcepts : AppCompatActivity() {

    lateinit var userDBHelper: UserDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_concepts)

        userDBHelper = UserDBHelper(this)
        var progress = userDBHelper.getProgress()

        val btnOverview = findViewById<Button>(R.id.btn_topic1)
        val btnBasicType = findViewById<Button>(R.id.btn_topic2)
        val btnOperators = findViewById<Button>(R.id.btn_topic3)
        val btnTypeConvertion = findViewById<Button>(R.id.btn_topic4)
        val btnES = findViewById<Button>(R.id.btn_topic5)
        val btnComment = findViewById<Button>(R.id.btn_topic6)

        btnOverview.setOnClickListener {

                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_1")
                myIntent.putExtra("topicNum", 1)
                startActivity(myIntent)

        }

        btnBasicType.setOnClickListener {

            progress = userDBHelper.getProgress()

            if(progress<1) {
                showPopupModal()
            }else {
                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_2")
                myIntent.putExtra("topicNum", 2)
                startActivity(myIntent)
            }
        }

        btnOperators.setOnClickListener {

            progress = userDBHelper.getProgress()

            if(progress<2) {
                showPopupModal()
            }else {
                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_3")
                myIntent.putExtra("topicNum", 3)
                startActivity(myIntent)
            }
        }

        btnTypeConvertion.setOnClickListener {

            progress = userDBHelper.getProgress()

            if(progress<3) {
                showPopupModal()
            }else {
                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_4")
                myIntent.putExtra("topicNum", 4)
                startActivity(myIntent)
            }
        }

        btnES.setOnClickListener {

            progress = userDBHelper.getProgress()

            if(progress<4) {
                showPopupModal()
            }else {
                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_5")
                myIntent.putExtra("topicNum", 5)
                startActivity(myIntent)
            }
        }

        btnComment.setOnClickListener {

            progress = userDBHelper.getProgress()

            if(progress<5) {
                showPopupModal()
            }else {
                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_6")
                myIntent.putExtra("topicNum", 6)
                startActivity(myIntent)
            }
        }
    }

    fun showPopupModal() {
        val inflater:LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.popup_layout_locked, null)
        val popupWindow = PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            popupWindow.elevation = 10.0F
        }

        // If API level 23 or higher then execute the code
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            // Create a new slide animation for popup window enter transition
            val slideIn = Slide()
            slideIn.slideEdge = Gravity.TOP
            popupWindow.enterTransition = slideIn

            // Slide animation for popup window exit transition
            val slideOut = Slide()
            slideOut.slideEdge = Gravity.RIGHT
            popupWindow.exitTransition = slideOut

        }

        popupWindow.width = 750
        popupWindow.height = 450

        val tv = view.findViewById<TextView>(R.id.tv_poopup_text)
        tv.setText("Complete the previous topics to unlock this one!")
        val btnPopup = view.findViewById<Button>(R.id.btn_ok)

        // Set a click listener for popup's button widget
        btnPopup.setOnClickListener{
            // Dismiss the popup window
            popupWindow.dismiss()
        }

        // Set a dismiss listener for popup window
        /*
        popupWindow.setOnDismissListener {
            Toast.makeText(applicationContext,"Good Job",Toast.LENGTH_SHORT).show()
        }
        */

        TransitionManager.beginDelayedTransition(home_layout)
        popupWindow.showAtLocation(
                home_layout,
                Gravity.CENTER,
                0,0
        )
    }
}
