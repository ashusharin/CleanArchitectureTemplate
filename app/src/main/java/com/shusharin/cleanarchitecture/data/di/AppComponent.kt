package com.shusharin.cleanarchitecture.data.di

import android.app.Application
import com.shusharin.cleanarchitecture.data.datasource.local.LocalDataSource
import com.shusharin.cleanarchitecture.data.datasource.local.LocalDataSourceImpl
import com.shusharin.cleanarchitecture.data.datasource.remote.RemoteDataSource
import com.shusharin.cleanarchitecture.data.datasource.remote.RemoteDataSourceImpl
import com.shusharin.cleanarchitecture.ui.main.MainActivity
import com.shusharin.cleanarchitecture.ui.mainScreen.MainScreenFragment
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, DomainModule::class, RetrofitModule::class, ViewModelModule::class, DatabaseModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainScreenFragment: MainScreenFragment)

    @Component.Factory
    interface AppComponentFactory {
        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }

}