package com.example.projectbgckmm.domain

import com.example.projectbgckmm.models.Response
import com.example.projectbgckmm.models.WeatherForecastResponse
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun  getWeatherForecast(): Flow<Response<WeatherForecastResponse>>
}
