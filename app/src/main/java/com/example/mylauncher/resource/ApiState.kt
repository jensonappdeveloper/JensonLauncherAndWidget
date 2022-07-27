package com.example.mylauncher.resource

import okhttp3.ResponseBody

sealed class ApiState<out T> {
    data class Success<out T>(val value: T) : ApiState<T>()
    data class Failure(

        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : ApiState<Nothing>()
    object Loading : ApiState<Nothing>()
}
