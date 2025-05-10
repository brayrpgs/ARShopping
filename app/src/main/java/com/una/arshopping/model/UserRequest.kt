package com.una.arshopping.model

data class UserRequest(
    val username: String,
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String
)