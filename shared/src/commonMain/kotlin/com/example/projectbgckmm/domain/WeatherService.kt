package com.example.projectbgckmm.domain

import com.example.projectbgckmm.models.WeatherForecastResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private val jsonFormatter = Json {
    ignoreUnknownKeys = true
}

class WeatherService {
    private val client: HttpClient = httpClient

    suspend fun getWeatherForecast(
        key: String = Config.api_key,
        location: String,
        days: String,
        aqi: String = "no",
        alerts: String = "no",
    ): WeatherForecastResponse {
        val response =
            client.get("https://api.weatherapi.com/v1/forecast.json?key=$key&q=$location&days=$days&aqi=$aqi&alerts=$alerts")
        val responseBody = response.bodyAsText()
        return jsonFormatter.decodeFromString(responseBody)
    }
}
