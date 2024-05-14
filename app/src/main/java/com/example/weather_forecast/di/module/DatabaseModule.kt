package com.example.weather_forecast.di.module

import android.app.Application
import androidx.room.Room
import com.example.weather_forecast.data.local.AppDatabase
import com.example.weather_forecast.data.local.LocalDataSource
import com.example.weather_forecast.data.local.WeatherDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(
    private val application: Application
) {
    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideWeatherDao(appDatabase: AppDatabase): WeatherDao {
        return appDatabase.weatherDao()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(weatherDao: WeatherDao): LocalDataSource {
        return LocalDataSource(weatherDao)
    }
}