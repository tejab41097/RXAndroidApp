package com.example.rxandroidapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.rxandroidapp.ui.firstFragment.FirstFragment
import com.example.rxandroidapp.ui.secondFragment.SecondFragment
import com.example.rxandroidapp.ui.thirdFragment.ThirdFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.secondFrag -> {
                    val sSecondFragment = SecondFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_holder, sSecondFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.thirdFrag -> {
                    val sThirdFragment = ThirdFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_holder, sThirdFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }
    }
}
