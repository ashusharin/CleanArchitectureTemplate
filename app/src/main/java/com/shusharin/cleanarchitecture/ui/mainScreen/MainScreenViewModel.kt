package com.shusharin.cleanarchitecture.ui.mainScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.shusharin.cleanarchitecture.domain.GetAllProductUseCase
import com.shusharin.cleanarchitecture.domain.Product
import kotlinx.coroutines.flow.*
import java.lang.Exception

import javax.inject.Inject

class MainScreenViewModel @Inject constructor( private val getAllProductUseCase: GetAllProductUseCase): ViewModel() {



    fun getProductList():Flow<List<Product>>{
        Log.d("getAllProduct", "ViewModel check" )
        return getAllProductUseCase()


    }
}