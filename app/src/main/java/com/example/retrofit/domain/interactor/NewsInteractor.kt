package com.example.retrofit.domain.interactor

import com.example.retrofit.domain.models.BaseItem
import io.reactivex.Observable
import io.reactivex.Single

interface NewsInteractor {

    fun getNews(search: String): Single<List<BaseItem>>
}