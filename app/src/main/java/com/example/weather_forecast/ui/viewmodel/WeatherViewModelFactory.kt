package com.example.weather_forecast.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weather_forecast.domain.usercase.GetWeatherDataUseCase
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class WeatherViewModelFactory @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return WeatherViewModel(getWeatherDataUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}