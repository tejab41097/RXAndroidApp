package com.example.rxandroidapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import com.example.rxandroidapp.ui.firstFragment.FirstFragment
import com.example.rxandroidapp.ui.secondFragment.SecondFragment
import com.example.rxandroidapp.ui.thirdFragment.ThirdFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val sFirstFragment = FirstFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_holder, sFirstFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        val sBottomNav: BottomNavigationView = findViewById(R.id.nav)
        sBottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.firstFrag -> {
                    val sFirstFragment = FirstFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_holder, sFirstFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit()
                }
                R.id.secondFrag -> {
                    val sSecondFragment = SecondFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_holder, sSecondFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit()
                }
                R.id.thirdFrag -> {
                    val sThirdFragment = ThirdFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_holder, sThirdFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit()
                }
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> {
                val toast = Toast(this)
                with(toast) {
                    makeText(this@MainActivity, "share", Toast.LENGTH_LONG)
                    setGravity(1, 1, 1)
                    show()
                }
            }
            R.id.about -> makeText(applicationContext, "About", Toast.LENGTH_LONG).show()
            R.id.setting -> makeText(applicationContext, "Settings", Toast.LENGTH_LONG).show()
            R.id.exit -> makeText(applicationContext, "Exit", Toast.LENGTH_LONG).show()
            R.id.search -> makeText(applicationContext, "Search", Toast.LENGTH_LONG).show()
        }
        return true
    }
}
