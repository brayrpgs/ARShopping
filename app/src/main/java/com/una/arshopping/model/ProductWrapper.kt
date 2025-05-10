package com.una.arshopping.model

data class ProductWrapper(
    val products: List<Product>,
    val pagination: Pagination
)