package com.shusharin.cleanarchitecture.domain

import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun first()
    fun getAllProduct(): Flow<List<Product>>

}