package com.example.nanda.kotlinhub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class ActivityTestReadText : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_read_text)

        val tv = findViewById<TextView>(R.id.tv1)
        val btnGetJson = findViewById<Button>(R.id.btn1)
        btnGetJson.setOnClickListener{
            JSONLoading(this, "topic_1", tv).execute()
        }

    }

    /*fun getJsonFile(){
        val inputStream: InputStream = resources.openRawResource(R.raw.test)
        val bis = BufferedInputStream(inputStream)
        val br  = BufferedReader(InputStreamReader(bis))
        val jsonData = StringBuffer()
        var line: String?

        do {
            line = br.readLine()
            if (line == null) {
                break
            }
            jsonData.append(line + "\n")

        } while (true)

        br.close()
        bis.close()
        var data = jsonData.toString()

    }

    fun parseJsonData(){

    }*/
}
