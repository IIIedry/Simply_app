package com.example.weather_forecast.domain.repository

import android.content.Context
import com.example.weather_forecast.domain.model.WeatherData

interface WeatherDataRepository {
    suspend fun getWeatherData(
        context: Context,
        latitude: Double,
        longitude: Double
    ): WeatherData
}