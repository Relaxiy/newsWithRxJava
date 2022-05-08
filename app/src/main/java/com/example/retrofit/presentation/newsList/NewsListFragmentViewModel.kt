package com.example.retrofit.presentation.newsList

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.domain.NewsInteractorFactory
import com.example.retrofit.domain.models.BaseItem
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class NewsListFragmentViewModel @Inject constructor() : ViewModel() {

    private val newsInteractorFactory = NewsInteractorFactory()

    val items: LiveData<List<BaseItem>> get() = _items
    private val _items = MutableLiveData<List<BaseItem>>()

    fun loadNews(search: String, context: Context) {
        val result = newsInteractorFactory.getNewsInteractor(context).getNews(search)
            .subscribeOn(Schedulers.io())
            .repeat(3)
            .delay(4, TimeUnit.SECONDS)
            .subscribe { list ->
                _items.postValue(list)
            }
    }
}