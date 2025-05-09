package com.una.arshopping.model

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatarUrl: String?,
    val isActive: Boolean,
    val password: String?
)