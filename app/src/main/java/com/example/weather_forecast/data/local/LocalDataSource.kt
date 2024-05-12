package com.example.weather_forecast.data.local

import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val weatherDao: WeatherDao
) {
    suspend fun upsertWeatherData(weatherData: WeatherData) {
        weatherDao.upsertWeatherData(
            WeatherEntityMapper.mapWeatherDataToWeatherEntity(weatherData)
        )
    }

    suspend fun getWeatherData(): WeatherData {
        return weatherDao.getWeatherData()?.let {
            WeatherEntityMapper.mapWeatherEntityToWeatherData(it)
        } ?: EmptyWeatherData.instance
    }
}