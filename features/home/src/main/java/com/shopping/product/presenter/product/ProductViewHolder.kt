package com.shopping.product.presenter.product

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.shopping.product.data.model.Product
import com.shopping.product.databinding.ListItemProductBinding

class ProductViewHolder(
    private val listItemProductBinding: ListItemProductBinding,
    private val onProductListener: (Product) -> Unit
) :
    RecyclerView.ViewHolder(listItemProductBinding.root) {

    fun onBindData(product: Product) {

        listItemProductBinding.apply {
            productTitle.text = product.title
            productImage.load(product.image)
        }

        listItemProductBinding.root.setOnClickListener {
            onProductListener(product)
        }
    }
}