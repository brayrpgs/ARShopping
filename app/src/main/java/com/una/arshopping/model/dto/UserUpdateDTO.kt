package com.una.arshopping.model.dto

data class UserUpdateDTO(
    val id: Int? = null,
    val email: String,
    val username: String,
    val avatarUrl: String? = null,
)
