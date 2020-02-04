package com.example.rxandroidapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.rxandroidapp.ui.firstFrag.FirstFragment
import com.example.rxandroidapp.ui.secondFrag.SecondFragment
import com.example.rxandroidapp.ui.thirdFrag.ThirdFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_holder, firstFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        val bottomNav: BottomNavigationView = findViewById(R.id.nav)
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.firstFrag -> {
                    val firstFragment = FirstFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_holder, firstFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.secondFrag -> {
                    val secondFragment = SecondFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_holder, secondFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.thirdFrag -> {
                    val thirdFragment = ThirdFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_holder, thirdFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }
    }
}
