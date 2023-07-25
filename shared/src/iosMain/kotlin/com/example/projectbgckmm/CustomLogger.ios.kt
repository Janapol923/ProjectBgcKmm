package com.example.projectbgckmm

import platform.Foundation.NSLog

actual class CustomLogger {
    actual fun log(message: String) {
        NSLog("LOG", "IOS_LOG: $message")
    }
}
