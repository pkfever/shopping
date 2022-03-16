package com.shopping.product.di

import com.shopping.product.data.repository.ProductRepositoryImpl
import com.shopping.product.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule by lazy {
    module {
        factory { ProductRepositoryImpl(get()) as ProductRepository  }
    }
}