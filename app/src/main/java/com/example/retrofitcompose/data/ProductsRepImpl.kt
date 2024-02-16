package com.example.retrofitcompose.data

import com.example.retrofitcompose.data.model.Product
import com.example.retrofitcompose.data.model.ProductX
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ProductsRepImpl(
    private val api: Api
): ProductsRepository {
    override suspend fun getProductsList(): Flow<Result<List<ProductX>>> {
        return  flow {
            val productsFromApi = try {
                api.getProductsList()
            }catch (e: IOException){
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products"))
                return@flow
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products"))
                return@flow
            }catch (e: Exception){
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products"))
                return@flow
            }
            emit(Result.Success(productsFromApi.products))
        }
    }
}