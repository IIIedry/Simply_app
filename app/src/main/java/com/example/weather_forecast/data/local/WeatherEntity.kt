package com.example.weather_forecast.data.local

@Entity(tableName = "weather_data")
data class WeatherEntity(
    @PrimaryKey val id: Int = 1,
    val background: Int,
    val sunrise: String,
    val sunset: String,
    val temperature: Double,
    val feelsLike: Double,
    val pressure: Int,
    val humidity: Int,
    val visibility: Int,
    val uvi: Double,
    val windSpeed: Double,
    val windDegree: Int,
    val weather: String,
    val forecasts: String
)