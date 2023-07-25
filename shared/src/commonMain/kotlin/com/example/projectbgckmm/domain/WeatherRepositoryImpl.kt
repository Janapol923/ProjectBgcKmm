package com.example.projectbgckmm.domain

import com.example.projectbgckmm.models.Response
import com.example.projectbgckmm.models.WeatherForecastResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherRepositoryImpl(
    private val service: WeatherService
): WeatherRepository {

    override fun getWeatherForecast(): Flow<Response<WeatherForecastResponse>> =
        flow {
            try {
                emit(Response.Loading)

                val responseApi = service.getWeatherForecast(location = "London", days = "3")
                emit(Response.Success(responseApi))
            } catch (e: Exception) {
                emit(Response.Failure(e))
            }
        }
}
