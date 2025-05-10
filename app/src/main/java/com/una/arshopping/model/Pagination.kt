package com.una.arshopping.model

data class Pagination(
    val totalItems: Int,
    val totalPages: Int,
    val currentPage: Int,
    val pageSize: Int
)