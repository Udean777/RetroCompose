package com.example.retrofitcompose.data

import com.example.retrofitcompose.data.model.Product
import com.example.retrofitcompose.data.model.ProductX
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProductsList(): Flow<Result<List<ProductX>>>
}