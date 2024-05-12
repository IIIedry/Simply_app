package com.example.weather_forecast.data.remote;

import com.example.weather_forecast.domain.model.WeatherData;

import javax.inject.Inject;

class RemoteDataSource @Inject constructor(
        private val weatherService: WeatherService
) {
    suspend fun getWeatherData(
            latitude: Double,
            longitude: Double
    ):WeatherData {
        val response = weatherService.getWeatherData(latitude, longitude)
        if (response.isSuccessful) {
            response.body()?.let {
                return WeatherResponseMapper.mapWeatherResponseToWeatherData(it)
            }
        }
        return EmptyWeatherData.instance
    }
}