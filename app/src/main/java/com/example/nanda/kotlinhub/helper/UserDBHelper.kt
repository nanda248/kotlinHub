package com.example.nanda.kotlinhub.helper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.example.nanda.kotlinhub.model.UserDataRecord
import com.example.nanda.kotlinhub.table.UserTableInfo

class SimpleUserRecord(val username: String, val points: Int, val email: String, val isLoggedIn: String, val progress: Int)

class UserDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "User.db"

        private val SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UserTableInfo.TABLE_NAME + " (" +
                        UserTableInfo.COLUMN_USERNAME + " TEXT," +
                        UserTableInfo.COLUMN_PASSWORD + " TEXT," +
                        UserTableInfo.COLUMN_EMAIL + " TEXT PRIMARY KEY," +
                        UserTableInfo.COLUMN_ISLOGGEDIN + " TEXT," +
                        UserTableInfo.COLUMN_PROGRESS + " TEXT," +
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

    fun registerUser(user: UserDataRecord): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put(UserTableInfo.COLUMN_USERNAME, user.username)
        values.put(UserTableInfo.COLUMN_PASSWORD, user.password)
        values.put(UserTableInfo.COLUMN_EMAIL, user.email)
        values.put(UserTableInfo.COLUMN_POINTS, user.points)
        values.put(UserTableInfo.COLUMN_ISLOGGEDIN, user.isLoggedIn)
        values.put(UserTableInfo.COLUMN_PROGRESS, user.progress)

        val newRowId = db.insert(UserTableInfo.TABLE_NAME,null, values)

        return true
    }

    fun loginUser(email: String, password: String): Boolean{
        val users = ArrayList<SimpleUserRecord>()
        val db = writableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery("select * from " +
                    UserTableInfo.TABLE_NAME + " WHERE " +
                    UserTableInfo.COLUMN_EMAIL + "=" + "'" + email + "'" + "", null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return false
        }

        var emailDB: String? = null
        var passwordDB: String? = null
        var username: String? = null

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                emailDB = cursor.getString(cursor.getColumnIndex(UserTableInfo.COLUMN_EMAIL))
                passwordDB = cursor.getString(cursor.getColumnIndex(UserTableInfo.COLUMN_PASSWORD))
                username = cursor.getString(cursor.getColumnIndex(UserTableInfo.COLUMN_USERNAME))
                cursor.moveToNext()
            }
        }

        if(email == emailDB && password == passwordDB) {
            val str:String = "UPDATE "+ UserTableInfo.TABLE_NAME+ " SET "+
                    UserTableInfo.COLUMN_ISLOGGEDIN + "='" + true +"' WHERE "+
                    UserTableInfo.COLUMN_USERNAME + "="+ "'"+username+"'"
            db.execSQL(str)
            return true
        }
        return false

    }

    fun updateProgress(progressId: Int, username: String) {
        val db = writableDatabase
        val str:String = "UPDATE "+ UserTableInfo.TABLE_NAME+ " SET "+
                UserTableInfo.COLUMN_PROGRESS + "=" + progressId +" WHERE "+
                UserTableInfo.COLUMN_USERNAME + "="+ "'"+username+"'"
        db.execSQL(str)
    }

//    fun countNumberOfUsers(): Int {
//        val modules = ArrayList<DataRecord>()
//        val db = writableDatabase
//        var cursor: Cursor? = null
//        try {
//            cursor = db.rawQuery("select count(*) from "+ UserTableInfo.TABLE_NAME, null)
//
//        } catch (e: SQLiteException) {
//            db.execSQL(SQL_CREATE_ENTRIES)
//            return 0
//        }
//
//        cursor.moveToFirst()
//        val count: Int = cursor.getInt(0)
//        cursor.close()
//        return count
//    }

    fun getUsername(): String {
        val db = writableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery("select * from " +
                    UserTableInfo.TABLE_NAME + " WHERE " +
                    UserTableInfo.COLUMN_ISLOGGEDIN + "='true'", null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return "Error fetching username"
        }
        var username: String = " "

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                username = cursor.getString(cursor.getColumnIndex(UserTableInfo.COLUMN_USERNAME))
                cursor.moveToNext()
            }
        }

        return username
    }

    fun getAllUsers(): ArrayList<SimpleUserRecord> {
        val users = ArrayList<SimpleUserRecord>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from "+ UserTableInfo.TABLE_NAME, null)

        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var username: String
        var email: String
        var points: Int
        var isLoggedIn: String
        var progress: Int
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                username = cursor.getString(cursor.getColumnIndex(UserTableInfo.COLUMN_USERNAME))
                email = cursor.getString(cursor.getColumnIndex(UserTableInfo.COLUMN_EMAIL))
                points = cursor.getInt(cursor.getColumnIndex(UserTableInfo.COLUMN_POINTS))
                isLoggedIn = cursor.getString(cursor.getColumnIndex(UserTableInfo.COLUMN_ISLOGGEDIN))
                progress = cursor.getInt(cursor.getColumnIndex(UserTableInfo.COLUMN_PROGRESS))
                users.add(SimpleUserRecord(username,points,email, isLoggedIn, progress))
                cursor.moveToNext()
            }
        }
        return users

    }

//    fun readUser(): Boolean {
//
//    }

}