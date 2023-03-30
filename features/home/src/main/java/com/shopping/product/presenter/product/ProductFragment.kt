package com.shopping.product.presenter.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.shopping.common.base.BaseFragment
import com.shopping.product.data.model.Product
import com.shopping.product.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductFragment : BaseFragment() {

    private lateinit var homeBinding: FragmentHomeBinding
    private val productViewModel: ProductViewModel by viewModel()

    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        homeBinding.lifecycleOwner = viewLifecycleOwner
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObserver()
        homeBinding.run {
            productAdapter = ProductAdapter(::onItemClick)
            productRecyclerView.adapter = productAdapter

        }
        productViewModel.getProducts()

    }

    private fun addObserver() {

        viewLifecycleOwner.lifecycleScope.launch {
            productViewModel.productList.collectLatest {
                productAdapter.productList = it
            }
        }

        productViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        productViewModel._loaderVisisble.observe(viewLifecycleOwner) {
            val visibility = if (it) View.VISIBLE else View.GONE
            homeBinding.productProgressBar.visibility = visibility
        }
    }

    private fun onItemClick(product: Product) {
        findNavController().navigate(
            ProductFragmentDirections.actionHomeFragmentToDetailFragment(product.id)
        )
    }
}