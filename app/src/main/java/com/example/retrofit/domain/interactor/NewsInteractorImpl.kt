package com.example.retrofit.domain.interactor

import com.example.retrofit.domain.models.BaseItem
import com.example.retrofit.domain.repository.NewsRepository
import com.example.retrofit.utils.ext.toBaseItems
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsInteractorImpl @Inject constructor(
    private val newsRepository: NewsRepository
) : NewsInteractor {

    override fun getNews(search: String): Single<List<BaseItem>> {
        return newsRepository.getNewsResponse(search)
            .subscribeOn(Schedulers.io())
            .map { newsResponse ->
                newsResponse.toBaseItems()
            }
    }

}