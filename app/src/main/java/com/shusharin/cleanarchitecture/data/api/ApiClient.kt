package com.shusharin.cleanarchitecture.data.api

import retrofit2.Response
import javax.inject.Inject

class ApiClient @Inject constructor(private val apiService: ServiceApi) {
    fun method() {
    }

    suspend fun getAllProduct(): Response<List<ProductListItem>> {
        return apiService.getAllProductList()
    }


}