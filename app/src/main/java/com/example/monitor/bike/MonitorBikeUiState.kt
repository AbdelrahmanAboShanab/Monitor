package com.example.monitor.bike

data class MonitorBikeUiState(
    val speed: String = "--",
    val distance: String = "--.--",
    val avgSpeed: String = "--.-",
    val range: String = "--",
    val time: String = "--:--",
    val battery: String = "--",
    val calories: String = "--",
)