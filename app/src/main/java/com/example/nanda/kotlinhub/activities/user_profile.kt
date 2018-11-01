package com.example.nanda.kotlinhub.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import com.example.nanda.kotlinhub.R
import com.example.nanda.kotlinhub.fragments.home_view
import com.example.nanda.kotlinhub.fragments.user_profile_view
import kotlinx.android.synthetic.main.activity_user_profile.*
import kotlinx.android.synthetic.main.app_bar_user_profile.*

class user_profile : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

//        val fragmentManager = supportFragmentManager
//        val transaction = fragmentManager.beginTransaction()
//        val userProfileFragment = profile_view()
//        transaction.add(R.id.user_frame_layout, userProfileFragment)
//        transaction.commit()

        val btnBasicConcept = findViewById<ImageButton>(R.id.btn_basic_concept)
        val btnCO = findViewById<ImageButton>(R.id.btn_class_object)
        val btnFun = findViewById<ImageButton>(R.id.btn_function)
        val btnMiscell = findViewById<ImageButton>(R.id.btn_miscellaneous)

        btnBasicConcept.setOnClickListener {
            val myIntent = Intent(this, ActivityBasicConcepts::class.java)
            startActivity(myIntent)
        }

        nav_view.setNavigationItemSelectedListener(this)



    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.user_profile, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_logout -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

//        val homeIntent = Intent(this,ActivityHomePage::class.java)
//        val profileIntent = Intent(this, ActivityProfilePage::class.java)
        when (item.itemId) {
            R.id.nav_home -> {
//                startActivity(homeIntent)
                val homeFragment = home_view()
                transaction.add(R.id.user_frame_layout, homeFragment)
            }
            R.id.nav_lesson -> {
//                startActivity(profileIntent)
                val userProfileFragment = user_profile_view()
                transaction.add(R.id.user_frame_layout, userProfileFragment)
            }
        }
        transaction.commit()

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
