package com.example.projectbgckmm.models

sealed class Response<out T> {

    object Loading : Response<Nothing>()

    data class Success<out T>(
        val data: T?
    ) : Response<T>()

    data class Failure(
        val e: Exception?
    ) : Response<Nothing>()
}

enum class Response2 {
    Loading,
    Success,
    Failure,
}
