package com.shopping.product.presenter.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.shopping.common.base.BaseFragment
import com.shopping.product.data.model.Product
import com.shopping.product.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductFragment : BaseFragment(), OnProductListener {

    private lateinit var homeBinding: FragmentHomeBinding
    private val productViewModel: ProductViewModel by viewModel()

    private lateinit var productAdapter: ProductAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addObserver()
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

        homeBinding.run {
            productAdapter = ProductAdapter(this@ProductFragment)
            productRecyclerView.adapter = productAdapter

        }
        productViewModel.getProducts()

    }

    private fun addObserver() {

        productViewModel.productList.observe(viewLifecycleOwner) {
            productAdapter.productList = it
        }

        productViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        productViewModel._loaderVisisble.observe(viewLifecycleOwner) {
            val visibility = if (it) View.VISIBLE else View.GONE
            homeBinding.productProgressBar.visibility = visibility
        }
    }

    override fun onItemClick(product: Product) {
        findNavController().navigate(
            ProductFragmentDirections.actionHomeFragmentToDetailFragment(product.id)
        )
    }
}