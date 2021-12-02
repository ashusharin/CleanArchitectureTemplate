package com.shusharin.cleanarchitecture.data.di

import com.shusharin.cleanarchitecture.data.datasource.local.LocalDataSource
import com.shusharin.cleanarchitecture.data.datasource.local.LocalDataSourceImpl
import com.shusharin.cleanarchitecture.data.datasource.remote.RemoteDataSource
import com.shusharin.cleanarchitecture.data.datasource.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun provideLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

    @Binds
    fun provideRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource



}