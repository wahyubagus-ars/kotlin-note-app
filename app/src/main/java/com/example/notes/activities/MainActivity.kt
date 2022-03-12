package com.example.notes.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.notes.R
import com.example.notes.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(HomeFragment.newInstance(), true)
    }

    fun replaceFragment(fragment:Fragment, isTransaction:Boolean){
        val fragmentTransition = supportFragmentManager.beginTransaction()

        if (isTransaction){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.add(R.id.frame_layout,fragment)
            .addToBackStack(fragment.javaClass.simpleName).commit()
    }
}