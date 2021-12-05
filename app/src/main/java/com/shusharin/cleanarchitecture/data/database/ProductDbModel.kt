package com.shusharin.cleanarchitecture.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Inject
@Entity
data class ProductDbModel@Inject constructor(
    @PrimaryKey
    val id: Int,
    val title: String,
    val price: Int,
    val description: String,
    val category: String,
    val image: String,
    val ratingRate: Int,
    val ratingCount: Int,
)

