package com.shopping.di

import com.shopping.common.data.di.createRemoteModule
import com.shopping.product.di.dataModule
import com.shopping.product.di.domainModule
import com.shopping.product.di.featureProductModule
import com.shopping.product.di.repositoryModule

val appComponent = listOf(
    createRemoteModule("https://fakestoreapi.com/"),
    dataModule,
    featureProductModule,
    repositoryModule,
    domainModule)