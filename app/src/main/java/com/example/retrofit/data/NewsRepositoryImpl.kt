package com.example.retrofit.data

import com.example.retrofit.data.api.NewsApi
import com.example.retrofit.data.models.NewsResponse
import com.example.retrofit.domain.repository.NewsRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsApi: NewsApi) : NewsRepository {
    override fun getNewsResponse(search: String): Single<NewsResponse> {
        val result = newsApi.getNews(
            query = search,
            language = "ru"
        ).subscribeOn(Schedulers.io())
        return result
    }
}