package com.example.mylauncher.repository



import com.example.mylauncher.resource.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {

    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): ApiState<T> {
        return withContext(Dispatchers.IO) {
            try {
                ApiState.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        ApiState.Failure(false, throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        ApiState.Failure(true, null, null)
                    }
                }
            }
        }
    }


}