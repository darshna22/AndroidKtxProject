package com.example.androidktxproject.utils

//out of generic use to provide or return data of T
// in to get data of T
sealed class NetworkResult<out R>(
) {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error<T>(val message: String) : NetworkResult<T>()
    object Loading : NetworkResult<Nothing>()
}
