package com.una.arshopping.network

import android.content.Context
import com.una.arshopping.data.ApiService
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

object RetrofitInstance {


    private const val BASE_URL = "http://10.0.2.2:3000/api/"
    private const val CACHE_SIZE: Long = 5 * 1024 * 1024 // 5 MB

    fun getInstance(context: Context): ApiService {
        val cacheDir = File(context.cacheDir, "http_cache")
        val cache = Cache(cacheDir, CACHE_SIZE)

        val cacheInterceptor = object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val response = chain.proceed(chain.request())
                return response.newBuilder()
                    .header("Cache-Control", "public, max-age=" + 60)//one minute time live
                    .build()
            }
        }

        val okHttpClient = OkHttpClient.Builder()
            .cache(cache)
            .addNetworkInterceptor(cacheInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }
}