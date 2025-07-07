package com.example.monitor.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ActivityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ActivityUiState())
    val uiState: StateFlow<ActivityUiState> = _uiState

    fun increaseLevel() {
        if (_uiState.value.level == AssistanceLevel.LEVEL_SMART) return
        _uiState.value = _uiState.value.copy(level = AssistanceLevel.entries.get(_uiState.value.level.number + 1))
    }

    fun decreaseLevel() {
        if (_uiState.value.level == AssistanceLevel.LEVEL_SMART) return
        _uiState.value = _uiState.value.copy(level = AssistanceLevel.entries.get(_uiState.value.level.number - 1))
    }

    fun enterSmartMode() {
        _uiState.value = _uiState.value.copy(level = AssistanceLevel.LEVEL_SMART)
    }

    fun exitSmartMode() {
        _uiState.value = _uiState.value.copy(level = AssistanceLevel.LEVEL_0)
    }

    fun toggleTracking() {
        _uiState.value = _uiState.value.copy(isRecordingActivity = !_uiState.value.isRecordingActivity)
    }

    // In a real application, these values would be updated by sensor data or other sources
    fun updateSpeed(newSpeed: Float) {
        _uiState.value = _uiState.value.copy(speed = newSpeed)
    }

    fun updateBattery(newBattery: String) {
        _uiState.value = _uiState.value.copy(battery = newBattery)
    }

    fun updateDistance(newDistance: String) {
        _uiState.value = _uiState.value.copy(distance = newDistance)
    }

    fun updateTime(newTime: String) {
        _uiState.value = _uiState.value.copy(time = newTime)
    }

    fun updateHeartRate(newHeartRate: String) {
        _uiState.value = _uiState.value.copy(heartRate = newHeartRate)
    }

    fun updateAvgSpeed(newAvgSpeed: String) {
        _uiState.value = _uiState.value.copy(avgSpeed = newAvgSpeed)
    }

} 