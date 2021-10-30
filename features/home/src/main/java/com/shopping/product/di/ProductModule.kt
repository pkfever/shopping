package com.shopping.product.di

import com.shopping.product.presenter.product.ProductViewModel
import com.shopping.product.presenter.detail.ProductDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureProductModule = module {
    viewModel { ProductViewModel(get()) }
    viewModel { ProductDetailViewModel(get()) }
}