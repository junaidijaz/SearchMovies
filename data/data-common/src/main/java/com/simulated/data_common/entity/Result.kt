package com.simulated.data_common.entity

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    class Error(val exception: AppException) : Result<Nothing>()
}