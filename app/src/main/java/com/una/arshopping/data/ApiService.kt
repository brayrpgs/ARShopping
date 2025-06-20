package com.una.arshopping.data

import com.una.arshopping.model.LoginRequest
import com.una.arshopping.model.UserRequest
import okhttp3.ResponseBody
import com.una.arshopping.model.LoginResponse
import com.una.arshopping.model.ProductResponse
import com.una.arshopping.model.User
import com.una.arshopping.model.UserOTPRequest
import com.una.arshopping.model.UserResponse
import com.una.arshopping.model.UserValidateOTPRequest
import com.una.arshopping.model.dto.UserUpdateDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @POST("/api/users")
    suspend fun createUser(@Body user: UserRequest): Response<ResponseBody>

    @PATCH("/api/users/{id}")
    suspend fun changePassword(@Path("id") id: Int?, @Body user: User): Response<ResponseBody>

    @DELETE("/api/users/{id}")
    suspend fun deleteUser(@Path("id") id: Int?): Response<ResponseBody>

    @POST("/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @PATCH("users/{id}")
    suspend fun updateUser(@Path("id") id: Int?, @Body userDto: UserUpdateDTO): User
    @GET("/api/users")
    suspend fun getUserByEmail(
        @Query("size") size: Int,
        @Query("page") page: Int,
        @Query("email") email: String
    ): Response<UserResponse>
    @GET("/api/products?size=9&page=1")
    suspend fun getProducts(): Response<ProductResponse>
    @POST("/api/users/recovery-password")
    suspend fun requestOTP(@Body user: UserOTPRequest): Response<ResponseBody>
    @POST("/api/users/confirm-recovery-password")
    suspend fun validateOTP(@Body user: UserValidateOTPRequest): Response<ResponseBody>

    @GET("/api/products")
    suspend fun getProductsFiltered(

        @Query("size") size: Int = 4,
        @Query("page") page: Int = 1,
        @Query("name") name: String? = null,
        @Query("store") store: String? = null

    ): Response<ProductResponse>
}