package com.example.retrofit.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit.R
import com.example.retrofit.di.ActivityComponent
import com.example.retrofit.di.DaggerActivityComponent
import com.example.retrofit.presentation.newsList.NewsListFragment
import com.example.retrofit.presentation.splashScreen.SplashScreenFragment
import com.example.retrofit.utils.ext.openFragment

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerActivityComponent.builder().viewStore(this).build()
    }

    override fun onStart() {
        super.onStart()
        openFragment(SplashScreenFragment.TAG, SplashScreenFragment.newInstance(), R.id.container)
    }
}