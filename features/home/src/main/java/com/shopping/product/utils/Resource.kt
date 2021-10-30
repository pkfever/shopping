package com.shopping.product.utils


data class Resource<out T>(val status: Status, val data: T?, val error: Throwable?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(error: Throwable): Resource<T> {
            return Resource(
                Status.ERROR,
                null,
                error
            )
        }
    }

    enum class Status {
        SUCCESS,
        ERROR
    }
}