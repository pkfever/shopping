package com.shopping.product.presenter.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shopping.common.base.BaseViewModel
import com.shopping.product.data.model.Product
import com.shopping.product.domain.usecase.GetProductDetailUseCase
import kotlinx.coroutines.launch

class ProductDetailViewModel(private val getProductDetailUseCase: GetProductDetailUseCase) :
    BaseViewModel() {

    private val _searchLiveData = MutableLiveData<Product>()
    val productLiveData : LiveData<Product> = _searchLiveData

    init {

    }

    fun getProductDetail(id: String?) {
        viewModelScope.launch {
            _loaderVisisble.value = true
            getProductDetailUseCase.execute(id).also { result ->
                _loaderVisisble.value = false
                when (result) {
                    is GetProductDetailUseCase.Result.Success -> {
//                        productLiveData.value = result.data
                        _searchLiveData.postValue(result.data)
                    }

                    is GetProductDetailUseCase.Result.Error -> {
                        error.value = result.errorMsg
                    }
                }
            }
        }
    }
}