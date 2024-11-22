package com.example.hw6_m3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hw6_m3.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ContinentFragment())
                .commit()
        }
    }
}
