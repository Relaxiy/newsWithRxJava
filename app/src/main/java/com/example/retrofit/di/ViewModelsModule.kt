package com.example.retrofit.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.retrofit.presentation.newsList.NewsListFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelsModule {
    @Provides
    fun provideNewsViewModel(
        viewModelStoreOwner: ViewModelStoreOwner
    ): NewsListFragmentViewModel{
        return ViewModelProvider(viewModelStoreOwner)[NewsListFragmentViewModel::class.java]
    }

}