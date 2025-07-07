package com.example.monitor.bike

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.monitor.ui.theme.Colors
import com.example.monitor.main.ActivityViewModel
import com.example.monitor.main.AssistanceLevel

@Composable
fun MonitorBikeScreen(
    viewModel: ActivityViewModel = viewModel(),
    vmMonitorBike: MonitorBikeViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()
    val monitorUiState by vmMonitorBike.uiState.collectAsState()


    val levelColor = when (uiState.level) {
        AssistanceLevel.LEVEL_0 -> {
            Colors.AssistLevel0()
        }
        AssistanceLevel.LEVEL_1 -> {
            Colors.AssistLevel1
        }
        AssistanceLevel.LEVEL_2 -> {
            Colors.AssistLevel2
        }
        AssistanceLevel.LEVEL_3 -> {
            Colors.AssistLevel3()
        }
        AssistanceLevel.LEVEL_SMART -> Colors.SmartAssist
        else -> {
            Colors.AssistLevel0()
        }
    }

    MonitorBikeScreenContent(
        assistantLevel = uiState.level,
        levelColor = levelColor,
        onDecreaseLevel = { viewModel.decreaseLevel() },
        onIncreaseLevel = { viewModel.increaseLevel() },
        speed = monitorUiState.speed,
        range = monitorUiState.range,
        battery = monitorUiState.battery,
        enterSmartMode = { viewModel.enterSmartMode() },
        exitSmartMode = { viewModel.exitSmartMode() }
    )

}

