package com.una.arshopping.data

import com.una.arshopping.model.ApiResponse
import com.una.arshopping.model.LoginRequest
import com.una.arshopping.model.UserRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/api/users")
    suspend fun createUser(@Body user: UserRequest): Response<ResponseBody>

    @POST("/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<ResponseBody>
}