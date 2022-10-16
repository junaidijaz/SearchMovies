package com.simulated.presentation_common.state

sealed class UiState<out T : Any> {
    object Loading : UiState<Nothing>()
    data class Error(val errorMessage: String) : UiState<Nothing>()
    data class Success<T : Any>(val data: T) : UiState<T>()
    data class NetworkError(val throwable: Throwable) : UiState<Throwable>()
}