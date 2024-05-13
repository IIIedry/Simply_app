package com.example.weather_forecast.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_forecast.domain.model.WeatherData
import com.example.weather_forecast.domain.usercase.GetWeatherDataUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase
) : ViewModel() {
    private val _weatherData = MutableLiveData<WeatherData>()

    val weatherData: LiveData<WeatherData> get() = _weatherData

    fun getWeatherData(
        context: Context,
        latitude: Double,
        longitude: Double
    ) {
        viewModelScope.launch {
            _weatherData.postValue(
                getWeatherDataUseCase.execute(context, latitude, longitude)
            )
        }
    }
}