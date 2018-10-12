package com.example.nanda.kotlinhub

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "User.db"

        private val SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UserTableInfo.TABLE_NAME + " (" +
                        UserTableInfo.COLUMN_USERNAME + " TEXT PRIMARY KEY," +
                        UserTableInfo.COLUMN_PASSWORD + " TEXT," +
                        UserTableInfo.COLUMN_EMAIL + " TEXT," +
                        UserTableInfo.COLUMN_ISLOGGEDIN + " TEXT," +
                        UserTableInfo.COLUMN_POINTS + " TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " +
                UserTableInfo.TABLE_NAME
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?,
                           oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?,
                             oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    fun loginUser(user: UserDataRecord): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put(UserTableInfo.COLUMN_USERNAME, user.username)
        values.put(UserTableInfo.COLUMN_PASSWORD, user.password)
        values.put(UserTableInfo.COLUMN_EMAIL, user.email)

        var result = readUser()

        val newRowId = db.insert(UserTableInfo.TABLE_NAME,
                null, values)
        return true
    }

    fun verifyLogin(): Boolean {

    }

    fun getUsername(): String {

    }

    fun readUser(): Boolean {

    }

}