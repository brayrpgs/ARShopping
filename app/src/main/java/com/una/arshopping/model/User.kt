package com.una.arshopping.model

data class User(
    val id: Int? = null,
    val email: String,
    val username: String,
    val avatarUrl: String? = null,
    val firstName: String ? = null,
    val lastName: String ? = null,
    val password: String? = null,
    val isActive: Boolean? = null
)