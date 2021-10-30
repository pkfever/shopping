package com.shopping.product.presenter.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shopping.common.base.BaseViewModel
import com.shopping.product.data.model.Product
import com.shopping.product.domain.usecase.GetProductListUseCase
import kotlinx.coroutines.launch

class ProductViewModel(private val getProductListUseCase: GetProductListUseCase) : BaseViewModel() {

    var productList = MutableLiveData<List<Product>>()

    fun getProducts() {
        viewModelScope.launch {
            _loaderVisisble.value = true
            getProductListUseCase.execute().also { result ->
                _loaderVisisble.value = false
                when (result) {
                    is GetProductListUseCase.Result.Success ->
                        productList.value = result.data

                    is GetProductListUseCase.Result.Error -> {
                        error.value = result.errorMsg
                    }
                }
            }
        }
    }
}