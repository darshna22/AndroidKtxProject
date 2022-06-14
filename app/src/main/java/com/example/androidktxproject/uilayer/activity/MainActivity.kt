package com.example.androidktxproject.uilayer.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidktxproject.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        supportFragmentManager.beginTransaction()
            .add(R.id.constraint_parent_container, CityListFragment()).commit()
    }


}