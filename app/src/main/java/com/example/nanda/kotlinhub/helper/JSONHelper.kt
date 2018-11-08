package com.example.nanda.kotlinhub.helper

import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class JSONHelper(var fileName: String, var c: Context) {

    companion object {
        var jsonData: String = ""
        private var topic = ArrayList<Section>()
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

    fun parse(): ArrayList<Section> {

        jsonData = load()

        try {
            val ja = JSONArray(jsonData)
            var jo : JSONObject

            topic.clear()
            var section: Section

            for (i in 0 until ja.length()) {
                jo = ja.getJSONObject(i)

                val id = jo.getInt("id")
                val topicName = jo.getString("topic")
                val sectionNum = jo.getInt("section")
                val title = jo.getString("title")

                val contentArray = jo.getJSONArray("content")
                val content: ArrayList<String> = ArrayList<String>(contentArray.length())
                for (i in 0 until contentArray.length())
                    content.add(contentArray.getString(i))

                val codeArray = jo.getJSONArray("code")
                var code: ArrayList<String>
                if(codeArray[0] == "N"){
                    code = ArrayList<String>(0)
                }else {
                    code = ArrayList<String>(codeArray.length())
                    for (i in 0 until codeArray.length())
                        code.add(codeArray.getString(i))
                }

                var highlight = jo.getString("highlight")
                if(highlight == "N"){
                    highlight = ""
                }

                section = Section(id, topicName, sectionNum, title, content, code, highlight)
                topic.add(section)


            }
            return topic
        } catch (e: JSONException) {
            e.printStackTrace()
            return ArrayList<Section>(0)
        }
    }
}

class Section(private var sectionID: Int, private var topicName: String,
              private var sectionNum:Int, private var title: String,
              private var content: ArrayList<String>, private var code: ArrayList<String>,
              private var highlight: String) {

    fun getSectionID(): Int {
        return sectionID
    }

    fun getTopicName(): String {
        return topicName
    }

    fun getSectionNum(): Int {
        return sectionNum
    }

    fun getSectionTitle(): String{
        return title
    }

    fun getContent(): ArrayList<String>{
        return content
    }

    fun getCode(): ArrayList<String>{
        return code
    }

    fun getHighlight(): String {
        return highlight
    }

}