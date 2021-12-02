package com.shusharin.cleanarchitecture.domain

import android.util.Log
import javax.inject.Inject

class FirstUseCase @Inject constructor(private val appRepository: AppRepository) {

    operator fun invoke() {
        return appRepository.first()
    }
}