package com.example.weather_forecast

import android.app.Application
import com.example.weather_forecast.di.component.AppComponent
import com.example.weather_forecast.di.component.DaggerAppComponent
import com.example.weather_forecast.di.module.DatabaseModule

class BaseApplication : Application() {
    companion object {
        lateinit var instance: BaseApplication
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        initializeAppComponent()
    }

    private fun initializeAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .databaseModule(DatabaseModule(instance))
            .build()
    }
}