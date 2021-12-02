package com.shusharin.cleanarchitecture.data.datasource.remote

import com.shusharin.cleanarchitecture.data.api.ApiClient
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiClient: ApiClient) :
    RemoteDataSource {
    override fun method() {
        apiClient.method()
    }
}