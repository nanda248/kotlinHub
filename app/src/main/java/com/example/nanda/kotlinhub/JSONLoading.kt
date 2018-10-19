package com.example.nanda.kotlinhub

import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class JSONLoading(private var c: Context, private var fileName: String,
                   private var myTextView: TextView): AsyncTask<Void, Void, String>(){

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Void?): String {

        return load()

    }

    override fun onPostExecute(jsonData: String) {
        super.onPostExecute(jsonData)

        JSONParser(c, jsonData, myTextView).execute()
    }


    private fun load(): String {

        //val inputStream: InputStream = c.resources.openRawResource(R.raw.fileName)
        val inputStream: InputStream = c.getResources().openRawResource(
                c.getResources().getIdentifier(fileName,
                        "raw", c.getPackageName()))
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

        return data

    }
}