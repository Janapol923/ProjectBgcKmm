package com.example.projectbgckmm

import android.util.Log

actual class CustomLogger {
    actual fun log(message: String) {
        Log.e("LOG", "ANDROID_LOG: $message")
    }
}
