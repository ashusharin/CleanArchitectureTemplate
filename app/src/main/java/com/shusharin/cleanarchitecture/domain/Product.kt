package com.shusharin.cleanarchitecture.domain

data class Product(
    val id: Int,
    val title: String,
    val price: Float,
    val description: String,
    val category: String,
    val image: String,
    val ratingRate: Float,
    val ratingCount: Int,
)




