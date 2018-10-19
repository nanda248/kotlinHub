package com.example.nanda.kotlinhub.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.nanda.kotlinhub.R
import com.example.nanda.kotlinhub.helper.JSONHelper
import com.example.nanda.kotlinhub.helper.Section

class ActivityTopic1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic1)

        var jsonHelper = JSONHelper("topic_1", this)
        var topic1: ArrayList<Section> = jsonHelper.parse()
        var section1 = topic1[0]

        displaySection(section1)

        var i = 1
        val btnNext = findViewById<Button>(R.id.btn_next)


        btnNext.setOnClickListener {
            if(i<topic1.size) {
                displaySection(topic1[i])
                i++
            }
        }
    }

    private fun displaySection(section: Section){

        val content = section.getContent()
        val code = section.getCode()
        val title = section.getSectionTitle()

        var contentString = ""
        for(i in 0 until content.size){
            contentString = contentString + content[i] + "\n" + "\n"
        }

        val tvTitle = findViewById<TextView>(R.id.tv_title)
        val tvContent = findViewById<TextView>(R.id.tv_content)

        tvTitle.text = title
        tvContent.text = contentString

        if(code.size>0) {
            var codeString = ""
            for (j in 0 until code.size) {
                codeString = codeString + code[j] + "\n"
            }
            val tvCode = findViewById<TextView>(R.id.tv_code)
            tvCode.text = codeString
            tvCode.setBackgroundResource(R.color.grey)
        }
    }
}
