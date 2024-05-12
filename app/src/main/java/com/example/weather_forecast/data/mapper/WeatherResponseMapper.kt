package com.example.weather_forecast.data.mapper

import com.example.weather_forecast.data.remote.CurrentWeather
import com.example.weather_forecast.data.remote.WeatherResponse
import com.example.weather_forecast.domain.model.Weather
import com.example.weather_forecast.domain.model.WeatherData
import com.example.weather_forecast.domain.model.DailyForecast
import com.example.weather_forecast.data.remote.DailyWeather
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object WeatherResponseMapper {
    fun mapWeatherResponseToWeatherData(response: WeatherResponse): WeatherData {
        val background = DrawableUtils.getBackgroundBasedOnTime(response.current.dt, response.timezone)
        val currentWeather = mapCurrentWeather(response.current, response.timezone)
        val dailyWeatherList = mapDailyWeather(response.daily, response.timezone)
        return WeatherData(background, currentWeather, dailyWeatherList)
    }

    private fun mapCurrentWeather(current: CurrentWeather, timezone: String): Weather {
        val weatherDescription = current.weather.firstOrNull()?.description.orEmpty()
        return Weather(
            sunrise = current.sunrise.toHMM(timezone),
            sunset = current.sunset.toHMM(timezone),
            temperature = current.temp,
            feelsLike = current.feelsLike,
            pressure = current.pressure,
            humidity = current.humidity,
            visibility = current.visibility,
            uvi = current.uvi,
            windSpeed = current.windSpeed,
            windDegree = current.windDeg,
            weather = weatherDescription
        )
    }

    private fun Long.toHMM(timezone: String): String {
        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone(timezone)
        return dateFormat.format(Date(this * 1000))
    }

    private fun Long.toEEE(timezone: String): String {
        val dateFormat = SimpleDateFormat("EEE", Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone(timezone)
        return dateFormat.format(Date(this * 1000))
    }

    private fun mapDailyWeather(daily: List<DailyWeather>, timezone: String): List<DailyForecast> {
        return daily.map {
            DailyForecast(
                day = it.dt.toEEE(timezone),
                temp = it.temp.day,
                icon = DrawableUtils.getIconForWeather(it.weather.firstOrNull()?.main.orEmpty())
            )
        }
    }
}
