package com.example.retrofit.utils.ext

import android.content.Context
import com.example.retrofit.di.ActivityComponent
import com.example.retrofit.presentation.MainActivity

val Context.activityComponent: ActivityComponent
    get() = when (this) {
        is MainActivity -> activityComponent
        else -> this.applicationContext.activityComponent
    }