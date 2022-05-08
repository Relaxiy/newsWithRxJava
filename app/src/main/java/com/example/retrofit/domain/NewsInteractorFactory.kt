package com.example.retrofit.domain

import android.content.Context
import com.example.retrofit.domain.interactor.NewsInteractor
import com.example.retrofit.utils.ext.activityComponent
import javax.inject.Inject

class NewsInteractorFactory {
    @Inject
    lateinit var interactor: NewsInteractor

    fun getNewsInteractor(context: Context) : NewsInteractor{
        context.activityComponent.inject(this)
        return interactor
    }
}