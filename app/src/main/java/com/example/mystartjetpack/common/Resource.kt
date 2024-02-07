package com.example.mystartjetpack.common

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    object Loading : Resource<Nothing>()
    class Success<T>(data: T?) : Resource<T>(data = data)
    class Error<T>(message: String?) : Resource<T>(message = message)
}