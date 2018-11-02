package com.example.nanda.kotlinhub.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.*
import com.example.nanda.kotlinhub.R
import com.example.nanda.kotlinhub.helper.UserDBHelper
import kotlinx.android.synthetic.main.activity_home_page.*

class ActivityHomePage : AppCompatActivity() {

    lateinit var userDBHelper: UserDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        userDBHelper = UserDBHelper(this)

        val btnBasicConcept = findViewById<ImageButton>(R.id.btn_basic_concept)
        val btnCO = findViewById<ImageButton>(R.id.btn_class_object)
        val btnFun = findViewById<ImageButton>(R.id.btn_function)
        val btnMiscell = findViewById<ImageButton>(R.id.btn_miscellaneous)
        val btnLessonPage = findViewById<ImageButton>(R.id.btn_lesson_page)
        val btnProfilePage = findViewById<ImageButton>(R.id.btn_profile_page)

        btnBasicConcept.setOnClickListener {
            val myIntent = Intent(this, ActivityBasicConcepts::class.java)
            startActivity(myIntent)
        }

        btnProfilePage.setOnClickListener {
            val myIntent = Intent(this, ActivityProfilePage::class.java)
            startActivity(myIntent)
        }

//        val username = userDBHelper.getUsername()
//        val testUsername = findViewById<TextView>(R.id.tv_test_username)
//        testUsername.setText(username)
        btnCO.setOnClickListener {
            showPopupModal()
        }

    }

    fun showPopupModal() {
        val inflater:LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.popup_layout, null)
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

        val tv = view.findViewById<TextView>(R.id.tv_poopup_text)
        tv.setText("Congratulation! You have completed n Level.")
        val btnPopup = view.findViewById<Button>(R.id.btn_yay)

        // Set click listener for popup window's text view
        tv.setOnClickListener{
            // Change the text color of popup window's text view
            tv.setTextColor(Color.CYAN)
        }

        // Set a click listener for popup's button widget
        btnPopup.setOnClickListener{
            // Dismiss the popup window
            popupWindow.dismiss()
        }

        // Set a dismiss listener for popup window
        popupWindow.setOnDismissListener {
            Toast.makeText(applicationContext,"Good Job",Toast.LENGTH_SHORT).show()
        }

        TransitionManager.beginDelayedTransition(home_layout)
        popupWindow.showAtLocation(
                home_layout,
                Gravity.CENTER,
                0,0
        )
    }
}
