package com.example.nanda.kotlinhub.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.nanda.kotlinhub.R
import com.example.nanda.kotlinhub.helper.JSONHelper
import com.example.nanda.kotlinhub.helper.Section

class ActivityTestReadText : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_read_text)

        val btnGetJson = findViewById<Button>(R.id.btn1)
        btnGetJson.setOnClickListener {
            var jsonHelper = JSONHelper("topic_1", this)
            var topic1: ArrayList<Section> = jsonHelper.parse()
            display(topic1)
        }

    }

    private fun display(topic: ArrayList<Section>){

        if(topic.size > 0) {
            val section1 = topic[0]
            val title = section1.getSectionTitle()
            val content = section1.getContent()
            val code = section1.getCode()

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
}
