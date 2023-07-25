package com.example.projectbgckmm.android.navigation

sealed class Routes(val destination: String) {
    object ForecastScreen : Routes("ForecastScreen")
    object WeatherDetailsScreen : Routes("WeatherDetailsScreen")
}
