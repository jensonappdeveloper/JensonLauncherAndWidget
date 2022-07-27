package com.example.mylauncher.repository

import com.example.mylauncher.network.ApiService
import javax.inject.Inject

class MainRepository  @Inject constructor(private val apiService: ApiService): BaseRepository() {


    suspend fun getWeatherInfo(
        url: String
    ) = safeApiCall {
        apiService.getWeatherInfo(url)
    }

}