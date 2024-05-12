package com.example.weather_forecast.data.repository

import android.content.Context
import com.example.weather_forecast.data.local.LocalDataSource
import com.example.weather_forecast.data.remote.RemoteDataSource
import com.example.weather_forecast.domain.model.WeatherData
import com.example.weather_forecast.domain.repository.WeatherDataRepository
import javax.inject.Inject

class WeatherDataRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : WeatherDataRepository {
    override suspend fun getWeatherData(
        context: Context,
        latitude: Double,
        longitude: Double
    ): WeatherData {
        return if (NetworkUtils.isNetworkConnected(context)) {
            val weatherData = remoteDataSource.getWeatherData(latitude, longitude)
            localDataSource.upsertWeatherData(weatherData)
            weatherData
        } else {
            localDataSource.getWeatherData()
        }
    }
}