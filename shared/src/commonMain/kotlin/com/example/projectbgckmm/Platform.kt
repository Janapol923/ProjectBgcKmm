package com.example.projectbgckmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
