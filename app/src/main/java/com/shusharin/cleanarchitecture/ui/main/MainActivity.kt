package com.shusharin.cleanarchitecture.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.shusharin.cleanarchitecture.R
import com.shusharin.cleanarchitecture.data.di.App
import com.shusharin.cleanarchitecture.ui.mainScreen.MainScreenFragment

class MainActivity() :
    AppCompatActivity() {

    private val appComponent by lazy {
        (application as App).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)
        val fragment: Fragment = MainScreenFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_Container, fragment).commit()
    }

}