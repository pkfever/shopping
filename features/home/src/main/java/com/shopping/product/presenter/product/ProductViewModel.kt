package com.shopping.product.presenter.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shopping.common.base.BaseViewModel
import com.shopping.product.data.model.Product
import com.shopping.product.domain.repository.ProductRepository
import com.shopping.product.domain.usecase.GetProductListUseCase
import com.shopping.product.utils.Resource
import kotlinx.coroutines.launch

class ProductViewModel(
    private val getProductListUseCase: GetProductListUseCase
) : BaseViewModel() {

    private val _searchLiveData = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>> = _searchLiveData

    fun getProducts() {
        viewModelScope.launch {
            _loaderVisisble.value = true
            getProductListUseCase.execute().also { result ->
                _loaderVisisble.value = false
                when (result) {
                    is GetProductListUseCase.Result.Success ->
                        _searchLiveData.value = result.data

                    is GetProductListUseCase.Result.Error -> {
                        error.value = result.errorMsg
                    }
                }
            }


        }
    }
}