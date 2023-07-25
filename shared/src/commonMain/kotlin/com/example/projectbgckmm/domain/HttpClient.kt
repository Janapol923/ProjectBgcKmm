package com.example.projectbgckmm.domain

import com.example.projectbgckmm.CustomLogger
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.HttpSendPipeline
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders

fun getHttpClient(): HttpClient {

    httpClient.sendPipeline.intercept(HttpSendPipeline.State) {
        context.headers.append("AppVersion", "version_here") //BuildConfig.VERSION_NAME)
    }
    return httpClient
}

val httpClient = HttpClient() {
    val log = CustomLogger()

    engine {

    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                log.log(message)
            }
        }
        level = LogLevel.ALL
    }

    install(ResponseObserver) {
        onResponse {
            log.log("HTTP Status: ${it.status.value}")
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
}

