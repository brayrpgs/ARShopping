package com.una.arshopping.model

data class Product(
    val urlIdentifier: String,
    val name: String,
    val price: String,
    val typeCoin: String,
    val store: String,
    val tags: String,
    val id: Int,
    val dateConsulted: String,
    val images: List<Image>
)