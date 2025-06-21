package com.una.arshopping.model

import com.una.arshopping.model.dto.UserInfoDTO

data class UserWrapper(
    val users: List<UserInfoDTO>,
    val pagination: Pagination
)
