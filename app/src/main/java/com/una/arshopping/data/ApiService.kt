package com.una.arshopping.data

import com.una.arshopping.model.ApiResponse
import com.una.arshopping.model.LoginRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("api/users")
    suspend fun getUser(): ApiResponse


    @POST("/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<ResponseBody>
}