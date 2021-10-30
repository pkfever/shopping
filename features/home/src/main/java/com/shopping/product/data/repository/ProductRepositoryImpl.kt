package com.shopping.product.data.repository

import com.shopping.product.data.model.Product
import com.shopping.product.data.remote.ProductDataSource
import com.shopping.product.domain.repository.ProductRepository
import com.shopping.product.utils.Resource

class ProductRepositoryImpl(private val productDataSource: ProductDataSource) : ProductRepository {

    override suspend fun getProducts(): Resource<List<Product>> {
        return try {
            val data = productDataSource.getProducts().body()
            Resource.success(data)
        } catch (e: Exception) {
            Resource.error(e)
        }
    }

    override suspend fun getProductsById(id: String?): Resource<Product> {

        return try {
            val data = productDataSource.getProductsDetailById(id).body()
            Resource.success(data)
        } catch (e: Exception) {
            Resource.error(e)
        }
    }
}