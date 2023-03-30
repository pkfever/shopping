package com.shopping.product.presenter.detail

import androidx.lifecycle.viewModelScope
import com.shopping.common.base.BaseViewModel
import com.shopping.product.data.model.Product
import com.shopping.product.domain.usecase.GetProductDetailUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class ProductDetailViewModel(private val getProductDetailUseCase: GetProductDetailUseCase) :
    BaseViewModel() {

    private val _searchFlow = MutableSharedFlow<Product>()    //private mutable live data
    val product : SharedFlow<Product> = _searchFlow   //publicly exposed as read-only livedata

    fun getProductDetail(id: String?) {
        viewModelScope.launch {
            _loaderVisisble.value = true
            getProductDetailUseCase(id).also { result ->
                _loaderVisisble.value = false
                when (result) {
                    is GetProductDetailUseCase.Result.Success -> {
                        _searchFlow.emit(result.data)
                    }

                    is GetProductDetailUseCase.Result.Error -> {
                        error.value = result.errorMsg
                    }
                }
            }
        }
    }
}