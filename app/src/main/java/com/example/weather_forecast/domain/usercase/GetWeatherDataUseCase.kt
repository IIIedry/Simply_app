package com.example.weather_forecast.domain.usercase

import android.content.Context
import com.example.weather_forecast.domain.model.WeatherData

interface GetWeatherDataUseCase {
    suspend fun execute(
        context: Context,
        latitude: Double,
        longitude: Double
    ): WeatherData
}