package com.shopping.product.dataset

import com.shopping.product.data.model.Product
import com.shopping.product.data.model.Rating

object ProductDataset {

    val FAKE_PRODUCTS = listOf(
        Product(
            "1",
            "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
            "109.95",
            "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
            "men's clothing",
            "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            Rating(3.9, 120)
        )
    )
}