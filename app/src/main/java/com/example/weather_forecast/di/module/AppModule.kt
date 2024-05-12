package com.example.weather_forecast.di.module

import com.example.weather_forecast.domain.repository.WeatherDataRepository
import com.example.weather_forecast.domain.usercase.GetWeatherDataUseCase
import com.example.weather_forecast.domain.usercase.GetWeatherDataUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideWeatherDataRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): WeatherDataRepository {
        return WeatherDataRepositoryImpl(
            localDataSource, remoteDataSource
        )
    }

    @Provides
    @Singleton
    fun provideGetWeatherDataUseCase(
        weatherDataRepository: WeatherDataRepository
    ): GetWeatherDataUseCase {
        return GetWeatherDataUseCaseImpl(weatherDataRepository)
    }
}