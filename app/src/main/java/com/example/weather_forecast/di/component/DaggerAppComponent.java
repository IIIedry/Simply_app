package com.example.weather_forecast.di.component;

import com.example.weather_forecast.data.local.AppDatabase;
import com.example.weather_forecast.data.local.LocalDataSource;
import com.example.weather_forecast.data.local.WeatherDao;
import com.example.weather_forecast.data.remote.RemoteDataSource;
import com.example.weather_forecast.data.remote.WeatherService;
import com.example.weather_forecast.di.module.AppModule;
import com.example.weather_forecast.di.module.DatabaseModule;
import com.example.weather_forecast.di.module.NetworkModule;
import com.example.weather_forecast.domain.repository.WeatherDataRepository;
import com.example.weather_forecast.domain.usercase.GetWeatherDataUseCase;
import com.example.weather_forecast.ui.MainActivity;
import com.example.weather_forecast.ui.MainActivity_MembersInjector;
import com.example.weather_forecast.ui.viewmodel.WeatherViewModelFactory;

import javax.annotation.processing.Generated;
import javax.inject.Provider;

import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;

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
public final class DaggerAppComponent {
    private DaggerAppComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private AppModule appModule;

        private NetworkModule networkModule;

        private DatabaseModule databaseModule;

        private Builder() {
        }

        public Builder appModule(AppModule appModule) {
            this.appModule = Preconditions.checkNotNull(appModule);
            return this;
        }

        public Builder networkModule(NetworkModule networkModule) {
            this.networkModule = Preconditions.checkNotNull(networkModule);
            return this;
        }

        public Builder databaseModule(DatabaseModule databaseModule) {
            this.databaseModule = Preconditions.checkNotNull(databaseModule);
            return this;
        }

        public AppComponent build() {
            if (appModule == null) {
                this.appModule = new AppModule();
            }
            if (networkModule == null) {
                this.networkModule = new NetworkModule();
            }
            Preconditions.checkBuilderRequirement(databaseModule, DatabaseModule.class);
            return new AppComponentImpl(appModule, networkModule, databaseModule);
        }
    }

    private static final class AppComponentImpl implements AppComponent {
        private final AppComponentImpl appComponentImpl = this;

        private Provider<AppDatabase> provideAppDatabaseProvider;

        private Provider<WeatherDao> provideWeatherDaoProvider;

        private Provider<LocalDataSource> provideLocalDataSourceProvider;

        private Provider<WeatherService> provideWeatherServiceProvider;

        private Provider<RemoteDataSource> provideRemoteDataSourceProvider;

        private Provider<WeatherDataRepository> provideWeatherDataRepositoryProvider;

        private Provider<GetWeatherDataUseCase> provideGetWeatherDataUseCaseProvider;

        private AppComponentImpl(AppModule appModuleParam, NetworkModule networkModuleParam,
                                 DatabaseModule databaseModuleParam) {

            initialize(appModuleParam, networkModuleParam, databaseModuleParam);

        }

        private WeatherViewModelFactory weatherViewModelFactory() {
            return new WeatherViewModelFactory(provideGetWeatherDataUseCaseProvider.get());
        }

        @SuppressWarnings("unchecked")
        private void initialize(final AppModule appModuleParam, final NetworkModule networkModuleParam,
                                final DatabaseModule databaseModuleParam) {
            this.provideAppDatabaseProvider = DoubleCheck.provider(DatabaseModule_ProvideAppDatabaseFactory.create(databaseModuleParam));
            this.provideWeatherDaoProvider = DoubleCheck.provider(DatabaseModule_ProvideWeatherDaoFactory.create(databaseModuleParam, provideAppDatabaseProvider));
            this.provideLocalDataSourceProvider = DoubleCheck.provider(DatabaseModule_ProvideLocalDataSourceFactory.create(databaseModuleParam, provideWeatherDaoProvider));
            this.provideWeatherServiceProvider = DoubleCheck.provider(NetworkModule_ProvideWeatherServiceFactory.create(networkModuleParam));
            this.provideRemoteDataSourceProvider = DoubleCheck.provider(NetworkModule_ProvideRemoteDataSourceFactory.create(networkModuleParam, provideWeatherServiceProvider));
            this.provideWeatherDataRepositoryProvider = DoubleCheck.provider(AppModule_ProvideWeatherDataRepositoryFactory.create(appModuleParam, provideLocalDataSourceProvider, provideRemoteDataSourceProvider));
            this.provideGetWeatherDataUseCaseProvider = DoubleCheck.provider(AppModule_ProvideGetWeatherDataUseCaseFactory.create(appModuleParam, provideWeatherDataRepositoryProvider));
        }

        @Override
        public void inject(MainActivity activity) {
            injectMainActivity(activity);
        }

        private MainActivity injectMainActivity(MainActivity instance) {
            MainActivity_MembersInjector.injectWeatherViewModelFactory(instance, weatherViewModelFactory());
            return instance;
        }
    }
}
