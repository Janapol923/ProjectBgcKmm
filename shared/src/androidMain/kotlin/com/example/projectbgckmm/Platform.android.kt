package com.example.projectbgckmm

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

val http = HttpClient() {

}

actual fun getPlatform(): Platform = AndroidPlatform()
