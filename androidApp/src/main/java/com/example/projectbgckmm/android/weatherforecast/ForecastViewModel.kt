package com.example.projectbgckmm.android.weatherforecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectbgckmm.domain.WeatherRepository
import com.example.projectbgckmm.domain.WeatherRepositoryImpl
import com.example.projectbgckmm.domain.WeatherService
import com.example.projectbgckmm.models.Response
import com.example.projectbgckmm.models.WeatherForecastResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ForecastViewModel(
    private val weatherRepository: WeatherRepository = WeatherRepositoryImpl(WeatherService())
) : ViewModel() {

    private val _forecastState =
        MutableStateFlow<Response<WeatherForecastResponse>>(Response.Success(null))
    val forecastState: StateFlow<Response<WeatherForecastResponse>> = _forecastState


    fun fetchWeatherForecast() {
        viewModelScope.launch {
            weatherRepository.getWeatherForecast().collect { response ->
                _forecastState.value = response
            }
        }
    }
}
