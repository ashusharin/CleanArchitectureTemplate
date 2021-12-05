package com.shusharin.cleanarchitecture.data.datasource.remote

import com.shusharin.cleanarchitecture.data.api.ProductListItem
import com.shusharin.cleanarchitecture.data.api.ProductResponse
import com.shusharin.cleanarchitecture.domain.Product
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RemoteDataSource {
    fun method()
    suspend fun getAllProduct(): Response<List<ProductListItem>>
}