package com.shopping.product.data.remote

import com.shopping.product.data.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>

    @GET("products/{id}")
    suspend fun getProductsDetail(@Path("id") id: String?,): Response<Product>
}