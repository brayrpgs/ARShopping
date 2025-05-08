package com.una.arshopping.data

import com.una.arshopping.model.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/users")
    suspend fun getUser(): ApiResponse
}