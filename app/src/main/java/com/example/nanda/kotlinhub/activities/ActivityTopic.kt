package com.example.nanda.kotlinhub.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.*
import com.example.nanda.kotlinhub.R
import com.example.nanda.kotlinhub.helper.JSONHelper
import com.example.nanda.kotlinhub.helper.Section
import com.example.nanda.kotlinhub.helper.UserDBHelper
import kotlinx.android.synthetic.main.activity_topic.*
import kotlinx.android.synthetic.main.activity_home_page.*

class ActivityTopic : AppCompatActivity() {
    lateinit var userDBHelper: UserDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic)

        var topicFile = intent.getStringExtra("topicFile")

        var jsonHelper = JSONHelper(topicFile, this)
        var topic: ArrayList<Section> = jsonHelper.parse()
        var section1 = topic[0]

        var sectionProgress = findViewById<ProgressBar>(R.id.pb_section)
        sectionProgress.max = topic.size
        sectionProgress.progress = 1

        displaySection(section1)

        userDBHelper = UserDBHelper(this)
        var i = 1
        val btnNext = findViewById<Button>(R.id.btn_next)

        val hasQuiz = true

        val username = userDBHelper.getUsername()

        btnNext.setOnClickListener {
            if(i<topic.size) {
                sectionProgress.progress = (i+1)
                displaySection(topic[i])
                userDBHelper.updateProgress(i, username)
                i++
            }else{
                if(hasQuiz == true) {
                    showPopupModalQuiz()
                } else {
                    showPopupModalNoQuiz()
                }
            }
        }


    }

    private fun displaySection(section: Section){

        val content = section.getContent()
        val code = section.getCode()
        val title = section.getSectionTitle()

        var contentString = ""
        for(i in 0 until content.size-1){
            contentString = contentString + content[i] + "\n" + "\n"
        }
        contentString = contentString + content[content.size-1] + "\n"

        val tvTitle = findViewById<TextView>(R.id.tv_title)
        val tvContent = findViewById<TextView>(R.id.tv_content)

        tvTitle.text = title
        tvContent.text = contentString

        if(code.size>0) {
            var codeString = ""
            for (j in 0 until code.size-1) {
                codeString += "   "
                codeString = codeString + code[j] + "\n"
            }
            codeString = codeString + "   " + code[code.size-1]
            val tvCode = findViewById<TextView>(R.id.tv_code)
            tvCode.text = codeString
            tvCode.setBackgroundResource(R.drawable.code_border)
        }
    }

    fun showPopupModalQuiz() {
        val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.popup_layout_with_quiz, null)
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
        tv.setText("Congratulation! You have completed this Level. Do you want to take the quiz now?")
        val btnLater = view.findViewById<Button>(R.id.btn_later)
        val btnYes = view.findViewById<Button>(R.id.btn_yes)

        btnYes.setOnClickListener {
            // Go to Quiz page (remove the line below)
            popupWindow.dismiss()
        }


        btnLater.setOnClickListener{
            popupWindow.dismiss()
        }

        popupWindow.setOnDismissListener {
            Toast.makeText(applicationContext,"Good Job", Toast.LENGTH_SHORT).show()
            finish()
        }

        TransitionManager.beginDelayedTransition(topic_layout)
        popupWindow.showAtLocation(
                topic_layout,
                Gravity.CENTER,
                0,0
        )
    }

    fun showPopupModalNoQuiz() {
        val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
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
        tv.setText("Congratulation! You have completed this Level.")
        val btnPopup = view.findViewById<Button>(R.id.btn_later)


        // Set a click listener for popup's button widget
        btnPopup.setOnClickListener{
            // Dismiss the popup window
            popupWindow.dismiss()
        }

        // Set a dismiss listener for popup window
        popupWindow.setOnDismissListener {
            Toast.makeText(applicationContext,"Good Job", Toast.LENGTH_SHORT).show()
            finish()
        }

        TransitionManager.beginDelayedTransition(topic_layout)
        popupWindow.showAtLocation(
                topic_layout,
                Gravity.CENTER,
                0,0
        )
    }
}
