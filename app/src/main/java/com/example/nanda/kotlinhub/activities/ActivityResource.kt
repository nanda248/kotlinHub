package com.example.nanda.kotlinhub.activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import com.example.nanda.kotlinhub.R

class ActivityResource : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        //https://www.youtube.com/watch?v=0isrdp5meyQ&t=7s
        val cardKotlin1 = findViewById<CardView>(R.id.card_kotlin_1)
        cardKotlin1.setOnClickListener {
            this.openYoutubeLink("0isrdp5meyQ")
        }

        val cardKotlin2 = findViewById<CardView>(R.id.card_kotlin_2)
        cardKotlin2.setOnClickListener {
            this.openYoutubeLink("3C-e4dTvrSI")
        }

        val cardKotlin3 = findViewById<CardView>(R.id.card_kotlin_3)
        cardKotlin3.setOnClickListener {
            this.openYoutubeLink("glX5Yx63_Vs")
        }

        val cardKotlin4 = findViewById<CardView>(R.id.card_kotlin_4)
        cardKotlin4.setOnClickListener {
            this.openYoutubeLink("NpveMP5869U")
        }

        val cardKotlin5 = findViewById<CardView>(R.id.card_kotlin_5)
        cardKotlin5.setOnClickListener {
            this.openYoutubeLink("4YF_DUMQqFA")
        }

        val cardKotlin6 = findViewById<CardView>(R.id.card_kotlin_6)
        cardKotlin6.setOnClickListener {
            this.openYoutubeLink("e-gZc-mZqE8")
        }

        val cardKotlin7 = findViewById<CardView>(R.id.card_kotlin_7)
        cardKotlin7.setOnClickListener {
            this.openYoutubeLink("YuRjPUxvcek")
        }

        val cardKotlin8 = findViewById<CardView>(R.id.card_kotlin_8)
        cardKotlin8.setOnClickListener {
            this.openYoutubeLink("8TW9zbgQnKc")
        }

        val cardKotlin9 = findViewById<CardView>(R.id.card_kotlin_9)
        cardKotlin9.setOnClickListener {
            this.openYoutubeLink("q_XZWtP6KQg")
        }

        val cardKotlin10 = findViewById<CardView>(R.id.card_kotlin_10)
        cardKotlin10.setOnClickListener {
            this.openYoutubeLink("9XmGh4WgfSg")
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }

    fun openYoutubeLink(youtubeId: String) {
        val intentApp = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+youtubeId))
        val intentBrowser = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + youtubeId))
        try {
            this.startActivity(intentApp)
        } catch (ex: ActivityNotFoundException) {
            this.startActivity(intentBrowser)
        }
    }
}
