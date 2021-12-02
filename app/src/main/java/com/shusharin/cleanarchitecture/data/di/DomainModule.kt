package com.shusharin.cleanarchitecture.data.di

import com.shusharin.cleanarchitecture.data.repository.AppRepositoryImpl
import com.shusharin.cleanarchitecture.domain.AppRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindRepository(impl: AppRepositoryImpl): AppRepository
}