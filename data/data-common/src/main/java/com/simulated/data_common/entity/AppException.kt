package com.simulated.data_common.entity

sealed class AppException(cause: Throwable) : Throwable(cause) {

    class MoviesException(cause: Throwable) : AppException(cause)

    class UnknownException(cause: Throwable) : AppException(cause)

    class NetworkErrorException(message: String) : NetworkError(message)

    companion object {

        fun createFromThrowable(throwable: Throwable): AppException {
            return if (throwable is AppException) throwable else UnknownException(throwable)
        }
    }
}

sealed class NetworkError(override val message: String?) : Throwable(message) {
    data class NetworkConnection(override val message: String) : NetworkError(message)
    data class BadRequest(override val message: String) : NetworkError(message)
    data class UnAuthorized(override val message: String) : NetworkError(message)
    data class InternalServerError(override val message: String) : NetworkError(message)
    data class ResourceNotFound(override val message: String) : NetworkError(message)
}