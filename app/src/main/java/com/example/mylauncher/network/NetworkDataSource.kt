package com.example.mylauncher.network

import android.content.Context
import com.android.volley.toolbox.HttpResponse
import okhttp3.OkHttpClient
import okhttp3.internal.http.HttpMethod
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class NetworkDataSource @Inject constructor() {

    companion object {
        private var BASE_URL = "http://weather.bfsah.com/"
    }


    fun <Api> buildApi(
        api: Class<Api>,
        context: Context,
        authToken: String? = null
    ): Api {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getRetrofitClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
    private val interceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private fun getRetrofitClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

}