package com.example.monitor.ui.main

data class ActivityUiState(
    val level: AssistanceLevel = AssistanceLevel.LEVEL_0,
    val isRecordingActivity: Boolean = false,
    val speed: Float = 0.0f,
    val battery: String = "00",
    val distance: String = "00",
    val time: String = "00:00",
    val heartRate: String = "00",
    val avgSpeed: String = "00"
) 