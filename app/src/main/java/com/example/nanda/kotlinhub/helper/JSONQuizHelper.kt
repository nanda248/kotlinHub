package com.example.nanda.kotlinhub.helper

import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class JSONQuizHelper(var fileName: String, var c: Context) {

    companion object {
        var jsonData: String = ""
        private var quiz = ArrayList<QnAns>()
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

    fun parse(): ArrayList<QnAns> {

        jsonData = load()

        try {
            val ja = JSONArray(jsonData)
            var jo : JSONObject

            quiz.clear()
            var qnAns: QnAns

            for (i in 0 until ja.length()) {
                jo = ja.getJSONObject(i)

                val qn = jo.getString("Qn")

                val codeArray = jo.getJSONArray("Code")
                var code: ArrayList<String>
                if(codeArray[0] == "N"){
                    code = ArrayList<String>(0)
                }else {
                    code = ArrayList<String>(codeArray.length())
                    for (i in 0 until codeArray.length())
                        code.add(codeArray.getString(i))
                }

                val optA = jo.getString("A")
                val optB = jo.getString("B")
                val optC = jo.getString("C")
                val optD = jo.getString("D")
                val ans = jo.getString("Ans")

                qnAns = QnAns(qn, code, optA, optB, optC, optD, ans)
                quiz.add(qnAns)


            }
            return quiz
        } catch (e: JSONException) {
            e.printStackTrace()
            return ArrayList<QnAns>(0)
        }
    }
}

class QnAns(private var qn: String, private var code: ArrayList<String>,
            private var optA: String, private var optB: String,
            private var optC: String, private var optD: String,
            private var ans: String) {


    fun getQn(): String{
        return qn
    }

    fun getCode(): ArrayList<String>{
        return code
    }

    fun getOptA(): String {
        return optA
    }

    fun getOptB(): String {
        return optB
    }

    fun getOptC(): String {
        return optC
    }

    fun getOptD(): String {
        return optD
    }

    fun getAns(): String {
        return ans
    }

}