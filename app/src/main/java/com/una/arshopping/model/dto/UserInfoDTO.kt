package com.una.arshopping.model.dto

data class UserInfoDTO(
    val id: Int? = null,
    val email: String,
    val username: String,
    val avatarUrl: String? = null,
    val isActive: Boolean
)