package com.shopping.product.di

import com.shopping.product.domain.usecase.GetProductDetailUseCase
import com.shopping.product.domain.usecase.GetProductListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetProductListUseCase(get()) }

    factory { GetProductDetailUseCase(get()) }
}