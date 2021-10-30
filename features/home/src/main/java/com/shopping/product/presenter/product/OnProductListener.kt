package com.shopping.product.presenter.product

import com.shopping.product.data.model.Product

interface OnProductListener {

    fun onItemClick(product: Product)
}