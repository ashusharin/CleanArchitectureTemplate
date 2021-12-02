package com.shusharin.cleanarchitecture.data.repository

import com.shusharin.cleanarchitecture.data.datasource.local.LocalDataSource
import com.shusharin.cleanarchitecture.data.datasource.remote.RemoteDataSource
import com.shusharin.cleanarchitecture.domain.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : AppRepository {

    override fun first() {

        remoteDataSource.method()
        localDataSource.method()
    }
}