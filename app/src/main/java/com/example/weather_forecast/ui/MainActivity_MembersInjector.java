package com.example.weather_forecast.ui;

import com.example.weather_forecast.ui.viewmodel.WeatherViewModelFactory;

import javax.annotation.processing.Generated;
import javax.inject.Provider;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;

@QualifierMetadata
@DaggerGenerated
@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://dagger.dev"
)
@SuppressWarnings({
        "unchecked",
        "rawtypes",
        "KotlinInternal",
        "KotlinInternalInJava"
})
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
    private final Provider<WeatherViewModelFactory> weatherViewModelFactoryProvider;

    public MainActivity_MembersInjector(
            Provider<WeatherViewModelFactory> weatherViewModelFactoryProvider) {
        this.weatherViewModelFactoryProvider = weatherViewModelFactoryProvider;
    }

    public static MembersInjector<MainActivity> create(
            Provider<WeatherViewModelFactory> weatherViewModelFactoryProvider) {
        return new MainActivity_MembersInjector(weatherViewModelFactoryProvider);
    }

    @Override
    public void injectMembers(MainActivity instance) {
        injectWeatherViewModelFactory(instance, weatherViewModelFactoryProvider.get());
    }

    @InjectedFieldSignature("com.sidharth.mosam.ui.MainActivity.weatherViewModelFactory")
    public static void injectWeatherViewModelFactory(MainActivity instance,
                                                     WeatherViewModelFactory weatherViewModelFactory) {
        instance.weatherViewModelFactory = weatherViewModelFactory;
    }
}

