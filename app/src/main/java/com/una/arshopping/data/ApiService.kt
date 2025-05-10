package com.una.arshopping.data

import com.una.arshopping.model.ApiResponse
import com.una.arshopping.model.LoginRequest
import com.una.arshopping.model.LoginResponse
import com.una.arshopping.model.User
import com.una.arshopping.model.dto.UserUpdateDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PATCH
import retrofit2.http.Path

interface ApiService {
    @GET("api/users")
    suspend fun getUser(): ApiResponse

    @POST("/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @PATCH("users/{id}")
    suspend fun updateUser(@Path("id") id: Int?, @Body userDto: UserUpdateDTO): User

}