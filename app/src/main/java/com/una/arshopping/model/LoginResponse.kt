package com.una.arshopping.model

import com.una.arshopping.model.dto.UserInfoDTO

data class LoginResponse (
    val message: String,
    val user: UserInfoDTO
)
