package com.shusharin.cleanarchitecture.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {


    @GET("/products")
    suspend fun getAllProductList(): Response<List<ProductListItem>>


}