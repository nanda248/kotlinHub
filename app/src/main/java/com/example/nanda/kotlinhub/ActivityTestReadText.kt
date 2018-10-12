package com.example.nanda.kotlinhub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_test_read_text.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class ActivityTestReadText : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_read_text)

        val btn = findViewById<Button>(R.id.btn1)
        btn.setOnClickListener {

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

            tv1.text = data
        }
    }
}
