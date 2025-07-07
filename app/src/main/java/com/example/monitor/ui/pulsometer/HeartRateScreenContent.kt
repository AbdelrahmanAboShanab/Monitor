package com.example.monitor.ui.pulsometer

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
import com.example.ui.common_composables.AppButton
import com.example.ui.common_composables.SpacerVertical
import com.example.monitor.ui.main.AssistanceLevel
import com.example.monitor.ui.composables.GridItem
import com.example.ui.theme.UiConstants
import com.example.ui.theme.UiConstants.componentSpacing
import com.example.ui.theme.mediumTextStyle
import com.example.monitor.ui.composables.LevelControl
import com.example.monitor.ui.composables.MonitorGrid
import com.example.monitor.ui.composables.SensitivityCounter
import com.mahle.sbs.monitor.ui.common.composables.SpeedSection
import com.example.ui.theme.MahleTheme
import com.example.ui.theme.level0textColor

@Composable
fun HeartRateScreenContent(
    assistantLevel: AssistanceLevel,
    levelColor: Color,
    onIncreaseLevel: () -> Unit,
    onDecreaseLevel: () -> Unit,
    speed: Float = 0.0f,
    enterSmartMode: () -> Unit,
    exitSmartMode: () -> Unit,
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
        }else{
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
            speed = speed.toString(),
            modifier = Modifier.fillMaxWidth(),
            isEnabled = false,
        )

        SpacerVertical(componentSpacing)

        val itemsList = listOf(
            GridItem(
                label = "Heart rate",
                value = "89",
                unit = "bpm"
            ),
            GridItem(
                label = "Av. Heart rate",
                value = "112",
                unit = "bpm"
            ),

            GridItem(
                label = "Zone HR",
                value = "2",
                unit = ""
            ),

            GridItem(
                label = "Calories",
                value = "124",
                unit = "Kcal"
            ),

            GridItem(
                label = "Battery",
                value = "90",
                unit = "%"
            ),

            GridItem(
                label = "Time",
                value = "12:59",
                unit = ""
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
                text = if (isSmartAssist) "Dissable Smart Assist" else "Smart Assist",
                iconId = R.drawable.ic_smart_assist,
                bgColor = levelColor,
                onClick = { if (isSmartAssist) exitSmartMode() else enterSmartMode() },
                textStyle = mediumTextStyle.copy(fontSize = 16.sp, color = appButtonTextColor),
                iconTint = if (assistantLevel == AssistanceLevel.LEVEL_0) MaterialTheme.colorScheme.level0textColor else Color.White
            )

            Spacer(modifier = Modifier.weight(1f))
     //   }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewPage() {
    MahleTheme {
        //  ActivityScreenContent()
    }
}