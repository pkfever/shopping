package com.shopping.product.presenter.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.shopping.common.base.BaseFragment
import com.shopping.product.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val productDetailViewModel: ProductDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        detailBinding.lifecycleOwner = viewLifecycleOwner
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addObserver()
        arguments?.let {
            val id = it.getString("id")
            productDetailViewModel.getProductDetail(id)
        }
    }

    private fun addObserver() {
        productDetailViewModel.productLiveData.observe(viewLifecycleOwner, { product ->

            detailBinding.productDescription.text = product.description
            detailBinding.productTitle.text = product.title
            detailBinding.productPrice.text = product.price
            detailBinding.productImage.load(product.image)
        })
    }
}