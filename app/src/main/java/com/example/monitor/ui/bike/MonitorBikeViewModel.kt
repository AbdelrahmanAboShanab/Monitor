package com.example.monitor.ui.bike

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MonitorBikeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(MonitorBikeUiState())
    val uiState = _uiState.asStateFlow()


    private fun getSpeed() {
        //Speed ,  Avg = distance /time so the Avg need activity to be calculated
        viewModelScope.launch {
//            bikeStateRepo.motor.collect {motorData ->
//                _uiState.update { it.copy(speed = motorData?.speedKmH.toString()) }
//            }
        }
    }

    private fun getRange() {
        // Range
        viewModelScope.launch {
//            bikeStateRepo.ebm.collect {ebmData ->
//                _uiState.update { it.copy(range = ebmData?.autonomy.toString()) }
//            }
        }
    }

    private fun getBattery() {
        //Battery
        viewModelScope.launch {
//            bikeStateRepo.batteryPrimary.collect { batteryData ->
//                _uiState.update { it.copy(battery = batteryData?.chargePercentage.toString()) }
//            }
        }
    }
}
