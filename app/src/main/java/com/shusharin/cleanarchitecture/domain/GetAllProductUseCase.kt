package com.shusharin.cleanarchitecture.domain


import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProductUseCase@Inject constructor(private val appRepository: AppRepository){

    operator fun invoke(): Flow<List<Product>> {
        return appRepository.getAllProduct()
    }
}