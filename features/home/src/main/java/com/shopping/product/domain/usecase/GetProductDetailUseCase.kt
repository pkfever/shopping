package com.shopping.product.domain.usecase

import com.shopping.product.data.model.Product
import com.shopping.product.domain.repository.ProductRepository
import com.shopping.product.utils.Resource

class GetProductDetailUseCase(private val productRepository: ProductRepository) {

    sealed interface Result {
        data class Success(val data: Product) : Result
        data class Error(val errorMsg: String) : Result
    }

    suspend operator fun invoke(id: String?): Result {

        val resource = productRepository.getProductsById(id)
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