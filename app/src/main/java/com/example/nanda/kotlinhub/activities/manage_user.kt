package com.example.nanda.kotlinhub.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.nanda.kotlinhub.R
import com.example.nanda.kotlinhub.helper.UserDBHelper


class manage_user : AppCompatActivity() {

    lateinit var userDBHelper: UserDBHelper
    lateinit var userList: ListView
    var countryList = arrayOf("India", "China", "australia", "Portugle", "America", "NewZealand")


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_user)

        userDBHelper = UserDBHelper(this)
        showUserList()

    }

    fun showUserList() {

        userList = findViewById(R.id.lv_user_accounts)

        val arrayAdapter = ArrayAdapter(this, R.layout.activity_listview_users, R.id.tv_user_list, countryList)
        userList.setAdapter(arrayAdapter)

        val allUsers = userDBHelper.getAllUsers()
        println("GETTING ALL USERS :::: YAY::: ")
        println(allUsers)
//        val userArray = arrayOfNulls<String>(allUsers.size)
//        allUsers.toArray(userArray)
//        println("CONVERTING arraylist to array: ")
//        println(countryList)
//        println(userArray)

    }
}
