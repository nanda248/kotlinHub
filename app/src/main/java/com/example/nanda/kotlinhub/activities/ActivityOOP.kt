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

class ActivityOOP : AppCompatActivity() {

    lateinit var userDBHelper: UserDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oop)

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        userDBHelper = UserDBHelper(this)
        var progress = userDBHelper.getProgress()

        val btnCO = findViewById<Button>(R.id.btn_topic16)
        val btnConstructor = findViewById<Button>(R.id.btn_topic17)
        val btnInheritance = findViewById<Button>(R.id.btn_topic18)
        val btnAbstract = findViewById<Button>(R.id.btn_topic19)
        val btnInterface = findViewById<Button>(R.id.btn_topic20)
        val btnData = findViewById<Button>(R.id.btn_topic21)
        val btnSealed = findViewById<Button>(R.id.btn_topic22)
        val btnCompanion = findViewById<Button>(R.id.btn_topic23)

        if(progress>15){btnCO.setBackgroundResource(R.drawable.checked_icon)}
        if(progress>16){btnConstructor.setBackgroundResource(R.drawable.checked_icon)}
        if(progress>17){btnInheritance.setBackgroundResource(R.drawable.checked_icon)}
        if(progress>18){btnAbstract.setBackgroundResource(R.drawable.checked_icon)}
        if(progress>19){btnInterface.setBackgroundResource(R.drawable.checked_icon)}
        if(progress>20){btnData.setBackgroundResource(R.drawable.checked_icon)}
        if(progress>21){btnSealed.setBackgroundResource(R.drawable.checked_icon)}
        if(progress>22){btnCompanion.setBackgroundResource(R.drawable.checked_icon)}

        btnCO.setOnClickListener {

            progress = userDBHelper.getProgress()

            if(progress<15) {
                showPopupModal()
            }else {
                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_16")
                myIntent.putExtra("topicNum", 16)
                startActivity(myIntent)
            }
        }

        btnConstructor.setOnClickListener {

            progress = userDBHelper.getProgress()

            if(progress<16) {
                showPopupModal()
            }else {
                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_17")
                myIntent.putExtra("topicNum", 17)
                startActivity(myIntent)
            }
        }

        btnInheritance.setOnClickListener {

            progress = userDBHelper.getProgress()

            if(progress<17) {
                showPopupModal()
            }else {
                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_18")
                myIntent.putExtra("topicNum", 18)
                startActivity(myIntent)
            }
        }

        btnAbstract.setOnClickListener {

            progress = userDBHelper.getProgress()

            if(progress<18) {
                showPopupModal()
            }else {
                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_19")
                myIntent.putExtra("topicNum", 19)
                startActivity(myIntent)
            }
        }

        btnInterface.setOnClickListener {

            progress = userDBHelper.getProgress()

            if(progress<19) {
                showPopupModal()
            }else {
                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_20")
                myIntent.putExtra("topicNum", 20)
                startActivity(myIntent)
            }
        }

        btnData.setOnClickListener {

            progress = userDBHelper.getProgress()

            if(progress<20) {
                showPopupModal()
            }else {
                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_21")
                myIntent.putExtra("topicNum", 21)
                startActivity(myIntent)
            }
        }

        btnSealed.setOnClickListener {

            progress = userDBHelper.getProgress()

            if(progress<21) {
                showPopupModal()
            }else {
                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_22")
                myIntent.putExtra("topicNum", 22)
                startActivity(myIntent)
            }
        }

        btnCompanion.setOnClickListener {

            progress = userDBHelper.getProgress()

            if(progress<22) {
                showPopupModal()
            }else {
                val myIntent = Intent(this, ActivityTopic()::class.java)
                myIntent.putExtra("topicFile", "topic_23")
                myIntent.putExtra("topicNum", 23)
                startActivity(myIntent)
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }

    fun showPopupModal() {
        val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
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
