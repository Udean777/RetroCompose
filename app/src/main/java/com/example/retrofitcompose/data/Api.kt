package com.example.retrofitcompose.data

import com.example.retrofitcompose.data.model.Product
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("products")
    suspend fun getProductsList(): Product
    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }
}