package com.una.arshopping.model

data class Image(
    val id: Int,
    val url: String,
    val created_at: String,
    val updated_at: String,
    val ProductImage: ProductImage
)