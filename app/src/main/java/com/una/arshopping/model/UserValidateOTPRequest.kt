package com.una.arshopping.model

import com.una.arshopping.model.dto.UserInfoDTO

data class UserValidateOTPRequest(
    val user: UserInfoDTO,
    val otp: String? = null,
    val newPassword: String? = null
)
