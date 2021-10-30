package com.shopping.product.domain.repository

import com.shopping.product.data.model.Product
import com.shopping.product.utils.Resource


interface ProductRepository {

    suspend fun getProducts() : Resource<List<Product>>

    suspend fun getProductsById(id: String?) : Resource<Product>
}