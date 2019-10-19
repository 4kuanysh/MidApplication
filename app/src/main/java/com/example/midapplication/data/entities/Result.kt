package com.example.midapplication.data.entities


sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    object Error: Result<Nothing>()
//    class Error(val exception: Throwable, val message: String = exception.localizedMessage) : Result<Nothing>()
}
