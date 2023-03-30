package com.shopping.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {

    var error: MutableLiveData<String> = MutableLiveData()
    val _loaderVisisble = MutableLiveData<Boolean>()
}