package com.example.weather_forecast.ui

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.weather_forecast.ui.theme.Weather_forecastTheme
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var weatherViewModelFactory: WeatherViewModelFactory

    private val weatherViewModel: WeatherViewModel by viewModels {
        weatherViewModelFactory
    }

    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val locationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val fineLocationGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
            val coarseLocationGranted =
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false

            if (fineLocationGranted || coarseLocationGranted) {
                getWeatherData()
            } else {
                finish()
            }
        }

override fun onPause() {
    super.onPause()
    NetworkUtils.stopNetworkCallback(applicationContext)
}

override fun onDestroy() {
    super.onDestroy()
    NetworkUtils.stopNetworkCallback(applicationContext)
}

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    WindowCompat.setDecorFitsSystemWindows(window, false)
    installSplashScreen()
    setContentView(activityMainBinding.root)
    initDependencyInjection()
    setupNetworkCallback()
    setupTransitionGenerator()
    observeBindWeatherData()
    getWeatherData()
}