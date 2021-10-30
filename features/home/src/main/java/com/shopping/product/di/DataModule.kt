package com.shopping.product.di

import com.shopping.product.data.remote.ProductDataSource
import com.shopping.product.data.remote.ProductService
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {

    factory { get<Retrofit>().create(ProductService::class.java) }

    factory { ProductDataSource(get()) }
}