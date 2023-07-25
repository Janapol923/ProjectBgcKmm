package com.example.projectbgckmm.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectbgckmm.android.weatherdetails.WeatherDetailsScreen
import com.example.projectbgckmm.android.weatherforecast.ForecastScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.ForecastScreen.destination) {
        composable(Routes.ForecastScreen.destination) {
            ForecastScreen(navController)
        }
        composable(Routes.WeatherDetailsScreen.destination) {
            WeatherDetailsScreen()
        }
    }
}
