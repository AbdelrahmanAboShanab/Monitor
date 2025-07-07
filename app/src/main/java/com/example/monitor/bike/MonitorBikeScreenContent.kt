package com.example.monitor.bike

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.monitor.R
import com.example.monitor.core.AppButton
import com.example.monitor.ui.GridItem
import com.example.monitor.ui.theme.UiConstants
import com.example.monitor.ui.theme.UiConstants.componentSpacing
import com.example.monitor.ui.composables.LevelControl
import com.example.monitor.main.AssistanceLevel
import com.example.monitor.ui.composables.MonitorGrid
import com.example.monitor.ui.composables.SensitivityCounter
import com.mahle.sbs.monitor.ui.common.composables.SpeedSection
import com.example.monitor.core.SpacerVertical
import com.example.monitor.ui.theme.MahleTheme
import com.example.monitor.ui.theme.level0textColor
import com.example.monitor.ui.theme.mediumTextStyle

@Composable
fun MonitorBikeScreenContent(
    assistantLevel: AssistanceLevel = AssistanceLevel.LEVEL_0,
    levelColor: Color = Color.Black,
    onIncreaseLevel: () -> Unit = {},
    onDecreaseLevel: () -> Unit = {},
    speed: String = "--",
    distance: String = "--",
    time: String = "--",
    riderWatts: String = "--",
    bikeWatts: String = "--",
    avgSpeed: String = "--",
    range: String = "--",
    battery: String = "--",
    calories: String = "--",
    enterSmartMode: () -> Unit = {},
    exitSmartMode: () -> Unit = {},
    isRecordingActivity: Boolean = false,
    ) {

    val isSmartAssist = assistantLevel == AssistanceLevel.LEVEL_SMART
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = UiConstants.screenMargin)
    ) {

        SpacerVertical(componentSpacing)

        val isIncreaseEnabled = assistantLevel != AssistanceLevel.LEVEL_3
        val isDecreaseEnabled = assistantLevel != AssistanceLevel.LEVEL_0
        if (isSmartAssist) {
            SensitivityCounter()
        } else {
            LevelControl(
                color = levelColor,
                onIncreaseLevel = onIncreaseLevel,
                onDecreaseLevel = onDecreaseLevel,
                isIncreaseEnabled = isIncreaseEnabled,
                isDecreaseEnabled = isDecreaseEnabled
            )
        }

        SpacerVertical(componentSpacing)

        SpeedSection(
            speed = speed,
            modifier = Modifier.fillMaxWidth(),
            isEnabled = false,
        )

        SpacerVertical(componentSpacing)

        val itemsList = if (isSmartAssist) listOf(
            GridItem(
                label = "Distance",
                value = distance,
                unit = "km"
            ),
            GridItem(
                label = "Time",
                value = time,
                unit = ""
            ),
            GridItem(
                label = "Rider Watts",
                value = riderWatts,
                unit = "W"
            ),
            GridItem(
                label = "Bike Watts",
                value = bikeWatts,
                unit = "W"
            ),
        ) else listOf(
            GridItem(
                label = "Distance",
                value = distance,
                unit = "km"
            ),
            GridItem(
                label = "Avg. Speed",
                value = avgSpeed,
                unit = "km/h"
            ),
            GridItem(
                label = "Range",
                value = range,
                unit = "km"
            ),
            GridItem(
                label = "Time",
                value = time,
                unit = ""
            ),
            GridItem(
                label = "Battery",
                value = battery,
                unit = "%"
            ),
            GridItem(
                label = "Calories",
                value = calories,
                unit = "kcal"
            ),
        )

        MonitorGrid(
            isRecordingActivity = isRecordingActivity,
            modifier = Modifier.fillMaxWidth(),
            items = itemsList
        )


        Spacer(modifier = Modifier.weight(1f))

        val appButtonTextColor =
            if (assistantLevel == AssistanceLevel.LEVEL_0) MaterialTheme.colorScheme.level0textColor else Color.White

        AppButton(
            text = if (isSmartAssist) "Deactivate Smart Assist" else "Smart Assist",
            iconId = R.drawable.ic_smart_assist,
            bgColor = levelColor,
            onClick = { if (isSmartAssist) exitSmartMode() else enterSmartMode() },
            textStyle = mediumTextStyle.copy(fontSize = 16.sp, color = appButtonTextColor),
            iconTint = if (assistantLevel == AssistanceLevel.LEVEL_0) MaterialTheme.colorScheme.level0textColor else Color.White
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewPage() {
    MahleTheme {
        MonitorBikeScreenContent()
    }
}