package com.example.mylauncher.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("temperature")
	val temperature: Int? = null,

	@field:SerializedName("description")
	val description: String? = null
)
