package com.example.retrofit.domain.repository

import com.example.retrofit.data.models.NewsResponse
import io.reactivex.Single

interface NewsRepository {

    fun getNewsResponse(search: String): Single<NewsResponse>
}