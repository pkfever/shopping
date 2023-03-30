package com.shopping.product.presenter.product

import androidx.lifecycle.viewModelScope
import com.shopping.common.base.BaseViewModel
import com.shopping.product.data.model.Product
import com.shopping.product.domain.usecase.GetProductListUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val getProductListUseCase: GetProductListUseCase
) : BaseViewModel() {

    private val _searchFlow = MutableSharedFlow<List<Product>>()
    val productList: SharedFlow<List<Product>> = _searchFlow

    fun getProducts() {
        viewModelScope.launch {
            _loaderVisisble.value = true
            getProductListUseCase().also { result ->
                _loaderVisisble.value = false
                when (result) {
                    is GetProductListUseCase.Result.Success ->
                        _searchFlow.emit(result.data)

                    is GetProductListUseCase.Result.Error -> {
                        error.value = result.errorMsg
                    }
                }
            }
        }
    }
}