package com.example.nanda.kotlinhub.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.*
import com.example.nanda.kotlinhub.R
import com.example.nanda.kotlinhub.helper.UserDBHelper
import java.io.*


class ActivityProfilePage : AppCompatActivity() {

    lateinit var userDBHelper: UserDBHelper
    lateinit var IMAGE_DIRECTORY: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        userDBHelper = UserDBHelper(this)

        val username = userDBHelper.getUsername()

        val btnResource = findViewById<Button>(R.id.btn_resource)
        btnResource.setOnClickListener{
            val myIntent = Intent(this, ActivityResource::class.java)
            startActivity(myIntent)
        }

        val btnLogout = findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            userDBHelper.logoutUser(username)
            startActivity(myIntent)
        }

        val btnLesson = findViewById<ImageButton>(R.id.btn_lesson_page)
        btnLesson.setOnClickListener {
            val myIntent = Intent(this, ActivityHomePage::class.java)
            startActivity(myIntent)
        }

        val tv_name_field = findViewById<TextView>(R.id.tv_name_field)
        val name_field_str = "Name: " + username.toString()
        tv_name_field.setText(name_field_str)

        val tv_progress = findViewById<TextView>(R.id.tv_progress)
        val progress = userDBHelper.getProgress()
        val progress_str = "Progress: " + progress.toString()
        tv_progress.setText(progress_str)

        val tv_email_field = findViewById<TextView>(R.id.tv_email_field)
        val email = userDBHelper.getEmail()
        val email_str = "Email: " + email.toString()
        tv_email_field.setText(email_str)

        val btnAddProfilePhoto = findViewById<ImageView>(R.id.imageView_profile_photo)
        btnAddProfilePhoto.setOnClickListener {
            selectImageInAlbum()
        }


        val btnQuiz = findViewById<Button>(R.id.btn_quiz)
        btnQuiz.setOnClickListener {
            val myIntent = Intent(this, ActivityQuizList::class.java)
            startActivity(myIntent)
        }

        val btnLessonPage = findViewById<ImageButton>(R.id.btn_lesson_page)
        btnLessonPage.setOnClickListener {
            val myIntent = Intent(this, ActivityHomePage::class.java)
            startActivity(myIntent)
        }
    }

    fun selectImageInAlbum() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 100)
            } else {
                startActivityForResult(intent, REQUEST_SELECT_IMAGE_IN_ALBUM)
            }
        }

//        if (intent.resolveActivity(packageManager) != null) {
//            startActivityForResult(intent, REQUEST_SELECT_IMAGE_IN_ALBUM)
//        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        if(requestCode == 100) {
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                startActivityForResult(intent, REQUEST_SELECT_IMAGE_IN_ALBUM)
            } else {
                Toast.makeText(this, "Permission not granted!", Toast.LENGTH_LONG).show()
            }
        }

    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        println("ON ACTIVITY RESULT >> >> > > >> > ")
        val imageViewProfile = findViewById<ImageView>(R.id.imageView_profile_photo)
        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == this.RESULT_CANCELED) {
//            return
//        }
            if (data != null) {
                val contentURI = data.data
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, contentURI)
                    val path = saveImage(bitmap)
                    println("PRINTING PATH TO PHOTO > >> > > > >")
                    println(path)
                    Toast.makeText(this@ActivityProfilePage, "Image Saved!", Toast.LENGTH_SHORT).show()
                    imageViewProfile.setImageBitmap(bitmap)

                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(this@ActivityProfilePage, "Failed!", Toast.LENGTH_SHORT).show()
                }

            }


    }

    fun saveImage(myBitmap: Bitmap): String {
        val bytes = ByteArrayOutputStream()
        IMAGE_DIRECTORY = "/Users/nanda/Documents/KotlinHub/app/src/main/res/drawable"
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
        val wallpaperDirectory = File("/Users/nanda/Documents/KotlinHub/app/src/main/res/drawable")

        println("Wallpaper directory > > > >> ")
        println(wallpaperDirectory.toString())
        // have the object build the directory structure, if needed.
        println(wallpaperDirectory.exists())
        if (!wallpaperDirectory.exists()) {
            println("THERE IS NO DIRECTORY FOR WALLPAPER > >> > ")
            val success = wallpaperDirectory.mkdirs()

            if(success) {
                println("SUCCESS FILE CREATION")
            }
        }
        println(wallpaperDirectory.exists())

//        // Get the context wrapper instance
//        val wrapper = ContextWrapper(applicationContext)
//
//        // Initializing a new file
//        // The bellow line return a directory in internal storage
//        var file = wrapper.getDir("images", Context.MODE_PRIVATE)


        // Create a file to save the image
//        file = File(file.path, "${UUID.randomUUID()}.jpg")
//        file = File(wallpaperDirectory, "TESTING.jpg")
//        file.createNewFile()
//        println("print file path > > >> >")
//        println(file.path)
//        println("absolute path > > > > > >")
//        println(file.absolutePath)
//        try {
//            // Get the file output stream
//            val stream: OutputStream = FileOutputStream(file)
//
//            // Compress bitmap
//            stream.write(bytes.toByteArray())
//            // Flush the stream
//            stream.flush()
//
//            // Close stream
//            stream.close()
//        } catch (e: IOException){ // Catch the exception
//            e.printStackTrace()
//        }
//
//        return Uri.parse(file.absolutePath).toString()
        try {
            println("TRY CREATE NEW FILE  > > >> > >> >")
            val f = File(wallpaperDirectory,
//                    Calendar.getInstance().getTimeInMillis().toString() +
                            "testing.jpg")

            println(f.absolutePath)
            println(f.path)
            println(f.isFile)
            println(f.isDirectory)
            val result = f.createNewFile()
            if(result) {
                println("FILE CREATED")
            }
            println("11111111")
            val fo: OutputStream = FileOutputStream(f)
            println("2222222")
            fo.write(bytes.toByteArray())
            println("BEFORE MEDIA SCANNER > >> > > >> >")
            MediaScannerConnection.scanFile(this,
                    arrayOf(f.getPath()),
                    arrayOf("image/jpeg"), null)
            fo.close()
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath())

            return f.getAbsolutePath()
        } catch (e1: IOException) {
            e1.printStackTrace()
        }

        return ""
    }
    companion object {
        private val REQUEST_SELECT_IMAGE_IN_ALBUM = 1
    }
}
