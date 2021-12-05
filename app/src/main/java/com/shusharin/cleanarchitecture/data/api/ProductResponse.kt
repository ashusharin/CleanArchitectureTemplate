package com.shusharin.cleanarchitecture.data.api

import com.google.gson.annotations.SerializedName

data class ProductResponse(val items: List<ProductListItem>)

data class ProductListItem(

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("price")
    val price: Float,

    @SerializedName("description")
    val description: String,

    @SerializedName("category")
    val category: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("rating")
    val rating: ProductRating,
)

data class ProductRating(

    @SerializedName("rate")
    val rate: Float,

    @SerializedName("count")
    val count: Int,
)