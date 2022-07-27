package com.example.mylauncher.network

import com.example.mylauncher.model.WeatherResponse
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getWeatherInfo(
        @Url url: String
    ): WeatherResponse


}