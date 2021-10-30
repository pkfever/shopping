package com.shopping.product.data.remote

class ProductDataSource(private val productService: ProductService) {

    suspend fun getProducts() = productService.getProducts()

    suspend fun getProductsDetailById(id: String?) = productService.getProductsDetail(id)
}