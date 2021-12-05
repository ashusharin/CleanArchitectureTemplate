package com.shusharin.cleanarchitecture.data.datasource.remote

import com.shusharin.cleanarchitecture.data.api.ApiClient
import com.shusharin.cleanarchitecture.data.api.ProductListItem
import com.shusharin.cleanarchitecture.data.api.ProductResponse
import com.shusharin.cleanarchitecture.domain.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiClient: ApiClient) :
    RemoteDataSource {
    override fun method() {
        apiClient.method()
    }

    override suspend fun getAllProduct(): Response<List<ProductListItem>> {
       return apiClient.getAllProduct()


    }
}