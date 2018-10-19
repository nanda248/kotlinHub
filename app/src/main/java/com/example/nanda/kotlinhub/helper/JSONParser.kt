package com.example.nanda.kotlinhub.helper

import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import android.widget.Toast
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class JSONParser(private var c: Context, private var jsonData: String,
                 private var myTextView: TextView): AsyncTask<Void, Void, Boolean>() {

    private var topic = ArrayList<Section>()

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg voids: Void): Boolean? {
        return parse()
    }

    override fun onPostExecute(isParsed: Boolean?) {
        super.onPostExecute(isParsed)

        if (isParsed!!) {

            myTextView.text = "parse successful -- " + topic.size + " " + topic[topic.size-1].getSectionID() +
                    " " + topic[topic.size-1].getSectionTitle() + " " +
                    topic[topic.size-1].getContent().get(0)

        } else {
            Toast.makeText(c, "Unable to Parse that data.", Toast.LENGTH_LONG).show()
            Toast.makeText(c, "This is the data that we are trying to parse : " + jsonData,
                    Toast.LENGTH_LONG).show()
        }
    }

    private fun parse(): Boolean {
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

                val highlight = jo.getString("highlight")
                val image = jo.getString("image")

                section = Section(id, topicName, sectionNum, title, content, highlight, image)
                topic.add(section)


            }
            return true
        } catch (e: JSONException) {
            e.printStackTrace()
            return false
        }
    }

    class Section(private var sectionID: Int, private var topicName: String,
                  private var sectionNum:Int, private var title: String,
                  private var content: ArrayList<String>, private var highlight: String,
                  private var img: String) {

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

        fun getHighlight(): String {
            return highlight
        }

        fun getImg(): String {
            return img
        }
    }

}
