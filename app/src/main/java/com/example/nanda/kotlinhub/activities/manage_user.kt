package com.example.nanda.kotlinhub.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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

    }


}
