package com.shusharin.cleanarchitecture.data.di

import com.shusharin.cleanarchitecture.data.datasource.local.LocalDataSource
import com.shusharin.cleanarchitecture.data.datasource.local.LocalDataSourceImpl
import com.shusharin.cleanarchitecture.data.datasource.remote.RemoteDataSource
import com.shusharin.cleanarchitecture.data.datasource.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, DomainModule::class, RetrofitModule::class])
interface AppComponent {


    @Component.Factory
    interface AppComponentFactory {
        fun create(
//            @BindsInstance context: Context,
        ): AppComponent
    }

}