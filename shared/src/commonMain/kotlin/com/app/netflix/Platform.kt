package com.app.netflix

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform