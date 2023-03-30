package com.shopping.product.presenter.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shopping.product.data.model.Product
import com.shopping.product.databinding.ListItemProductBinding
import kotlin.properties.Delegates

class ProductAdapter( private val onProductListener: (Product) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var productList: List<Product> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val listItemProductBinding =
            ListItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(listItemProductBinding, onProductListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val productObj = productList[position]
        (holder as ProductViewHolder).onBindData(productObj)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}