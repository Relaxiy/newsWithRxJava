package com.example.retrofit.di

import androidx.lifecycle.ViewModelStoreOwner
import com.example.retrofit.domain.NewsInteractorFactory
import com.example.retrofit.presentation.newsList.NewsListFragment
import com.example.retrofit.presentation.splashScreen.SplashScreenFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RetrofitModule::class,
        BindRepositoriesModule::class,
        BindInteractorsModule::class,
        ViewModelsModule::class
    ]
)
interface ActivityComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun viewStore(viewModelStoreOwner: ViewModelStoreOwner): Builder

        fun build(): ActivityComponent
    }

    //Fragments
    fun inject(newsListFragment: NewsListFragment)
    fun inject(splashScreenFragment: SplashScreenFragment)

    fun inject(newsInteractorFactory: NewsInteractorFactory)
}