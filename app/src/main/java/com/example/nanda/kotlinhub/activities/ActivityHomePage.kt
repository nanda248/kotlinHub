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
import android.widget.*
import com.example.nanda.kotlinhub.R
import com.example.nanda.kotlinhub.helper.UserDBHelper
import kotlinx.android.synthetic.main.activity_home_page.*

class ActivityHomePage : AppCompatActivity() {

    lateinit var userDBHelper: UserDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val btnBasicConcept = findViewById<ImageButton>(R.id.btn_basic_concept)
        val btnFC = findViewById<ImageButton>(R.id.btn_class_object)
        val btnFunction = findViewById<ImageButton>(R.id.btn_function)
        val btnOOP = findViewById<ImageButton>(R.id.btn_miscellaneous)
        val btnLessonPage = findViewById<ImageButton>(R.id.btn_lesson_page)
        val btnProfilePage = findViewById<ImageButton>(R.id.btn_profile_page)

        val progBar1 = findViewById<ProgressBar>(R.id.progressBar1)
        val progBar2 = findViewById<ProgressBar>(R.id.progressBar2)
        val progBar3 = findViewById<ProgressBar>(R.id.progressBar3)
        val progBar4 = findViewById<ProgressBar>(R.id.progressBar4)

        userDBHelper = UserDBHelper(this)
        var progress = userDBHelper.getProgress()


        if(progress in 1..5){

            progBar1.setProgress(progress)
            btnBasicConcept.setBackgroundResource(R.drawable.activate_stage1)

        }else if(progress in 6..11){

            progBar1.setProgress(6)
            progBar2.setProgress(progress-6)
            btnBasicConcept.setBackgroundResource(R.drawable.activate_stage1)
            btnFC.setBackgroundResource(R.drawable.activate_stage1)

        }else if(progress in 12..14){

            progBar1.setProgress(6)
            progBar2.setProgress(6)
            progBar3.setProgress(progress-12)
            btnBasicConcept.setBackgroundResource(R.drawable.activate_stage1)
            btnFC.setBackgroundResource(R.drawable.activate_stage1)
            btnFunction.setBackgroundResource(R.drawable.activate_stage1)

        }else if(progress in 15..22){

            progBar1.setProgress(6)
            progBar2.setProgress(6)
            progBar3.setProgress(3)
            progBar4.setProgress(progress-15)
            btnBasicConcept.setBackgroundResource(R.drawable.activate_stage1)
            btnFC.setBackgroundResource(R.drawable.activate_stage1)
            btnFunction.setBackgroundResource(R.drawable.activate_stage1)
            btnOOP.setBackgroundResource(R.drawable.activate_stage1)

        }else if(progress == 23){

            progBar1.setProgress(6)
            progBar2.setProgress(6)
            progBar3.setProgress(3)
            progBar4.setProgress(8)
            btnBasicConcept.setBackgroundResource(R.drawable.activate_stage1)
            btnFC.setBackgroundResource(R.drawable.activate_stage1)
            btnFunction.setBackgroundResource(R.drawable.activate_stage1)
            btnOOP.setBackgroundResource(R.drawable.activate_stage1)
            btn_success.setBackgroundResource(R.drawable.activate_stage2)

        }

        btnLessonPage.setOnClickListener{
            finish()
            startActivity(getIntent())
        }

        btnProfilePage.setOnClickListener {
            val myIntent = Intent(this, ActivityProfilePage::class.java)
            startActivity(myIntent)
        }

        btnBasicConcept.setOnClickListener {
            val myIntent = Intent(this, ActivityBasicConcepts::class.java)
            startActivity(myIntent)
        }

        btnFC.setOnClickListener {
            if(progress>=6) {
                val myIntent = Intent(this, ActivityFlowControl::class.java)
                startActivity(myIntent)
            }else{
                showPopupModal()
            }
        }


        btnFunction.setOnClickListener {
            if(progress>=12) {
                val myIntent = Intent(this, ActivityFunction::class.java)
                startActivity(myIntent)
            }else{
                showPopupModal()
            }
        }

        btnOOP.setOnClickListener {
            if(progress>=15) {
                val myIntent = Intent(this, ActivityOOP::class.java)
                startActivity(myIntent)
            }else{
                showPopupModal()
            }
        }



    }

    override fun onBackPressed() {
        // Do Here what ever you want do on back press;
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

        val tv = view.findViewById<TextView>(R.id.tv_poopup_text)
        tv.setText("Complete the previous modules to unlock this one!")
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
