package com.example.nanda.kotlinhub.helper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.example.nanda.kotlinhub.model.UserDataRecord
import com.example.nanda.kotlinhub.table.UserTableInfo

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


        val newRowId = db.insert(UserTableInfo.TABLE_NAME,null, values)
        println("New Row ID CREATED: ")
        println(newRowId)
        return true
    }


    fun countNumberOfUsers(): Int {
//        val modules = ArrayList<DataRecord>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select count(*) from "+ UserTableInfo.TABLE_NAME, null)

        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return 0
        }

        cursor.moveToFirst()
        val count: Int = cursor.getInt(0)
        println("Counted number of users")
        println(count)
        cursor.close()
        return count
    }

    fun getUsername(): String {
        var username : String = "Default Name"
        val db = writableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery("select * from " +
                    UserTableInfo.TABLE_NAME + " WHERE " +
                    UserTableInfo.COLUMN_ISLOGGEDIN + "=" + true + "", null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return "Error fetching username"
        }
        var isLoggedIn: String
        var usernameDB: String

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                isLoggedIn = cursor.getString(cursor.getColumnIndex(UserTableInfo.COLUMN_ISLOGGEDIN))
                usernameDB = cursor.getString(cursor.getColumnIndex(UserTableInfo.COLUMN_USERNAME))
                username = usernameDB
//                modules.add(DataRecord(course_code, numOfStudents, level))
                cursor.moveToNext()
            }
        }

        return username
    }

//    fun readUser(): Boolean {
//
//    }

}