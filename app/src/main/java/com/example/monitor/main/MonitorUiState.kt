package com.example.monitor.main

data class MonitorUiState(
    val level: Int = 0,
    val isTracking: Boolean = false,
    val speed: Float = 0.0f,
    val battery: String = "00",
    val distance: String = "00",
    val time: String = "00:00",
    val heartRate: String = "00",
    val avgSpeed: String = "00"
) 