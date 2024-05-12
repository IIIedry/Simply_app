package com.example.weather_forecast.domain.usercase

import android.content.Context
import com.example.weather_forecast.domain.model.WeatherData
import com.example.weather_forecast.domain.repository.WeatherDataRepository
import javax.inject.Inject

class GetWeatherDataUseCaseImpl @Inject constructor(
    private val weatherDataRepository: WeatherDataRepository
) : GetWeatherDataUseCase {
    override suspend fun execute(
        context: Context,
        latitude: Double,
        longitude: Double
    ): WeatherData {
        return weatherDataRepository.getWeatherData(context, latitude, longitude)
    }
}