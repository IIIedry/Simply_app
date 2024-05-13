package com.example.weather_forecast.di.component

import com.example.weather_forecast.di.module.AppModule
import com.example.weather_forecast.di.module.DatabaseModule
import com.example.weather_forecast.di.module.NetworkModule
import com.example.weather_forecast.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class,
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}