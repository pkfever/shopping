package com.shopping.product.domain.usecase

import com.shopping.product.data.model.Product
import com.shopping.product.domain.repository.ProductRepository
import com.shopping.product.utils.Resource


class GetProductListUseCase(private val productRepository: ProductRepository) {

    sealed interface Result {
        data class Success(val data: List<Product>) : Result
        data class Error(val errorMsg: String) : Result
    }

    /*
        Handle app logics in here before sending the data to presnenter layer
     */
    suspend fun execute(): Result {

        val resource = productRepository.getProducts()
        return when (resource.status) {

            Resource.Status.SUCCESS -> {
                Result.Success(resource.data!!)
            }

            Resource.Status.ERROR -> {
                Result.Error("Something went wrong!")
            }
        }
    }
}