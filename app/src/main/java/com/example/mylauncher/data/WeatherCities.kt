package com.example.mylauncher.data

import android.net.Uri
import java.util.*

internal object WeatherCities {
    private val random = Random()
    private val cities = arrayOf("beijing", "berlin", "cardiff", "edinburgh","london","nottingham")

    fun randomCities(): String {
        val index = random.nextInt(cities.size)
        return cities[index]
    }

    fun randomCitiesId(): Int {
        val index = random.nextInt(cities.size)
        return index
    }
}