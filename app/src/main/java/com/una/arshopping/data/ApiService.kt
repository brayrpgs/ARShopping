package com.una.arshopping.data

import com.una.arshopping.model.LoginRequest
import com.una.arshopping.model.UserRequest
import okhttp3.ResponseBody
import com.una.arshopping.model.LoginResponse
import com.una.arshopping.model.ProductResponse
import com.una.arshopping.model.User
import com.una.arshopping.model.dto.UserUpdateDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PATCH
import retrofit2.http.Path

interface ApiService {
    @POST("/api/users")
    suspend fun createUser(@Body user: UserRequest): Response<ResponseBody>
    @PATCH("/api/users/{id}")
    suspend fun changePassword(@Path("id") id: Int?,@Body user: User): Response<ResponseBody>
    @POST("/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
    @PATCH("users/{id}")
    suspend fun updateUser(@Path("id") id: Int?, @Body userDto: UserUpdateDTO): User
    @GET("/api/products?size=9&page=1")
    suspend fun getProducts(): Response<ProductResponse>
}