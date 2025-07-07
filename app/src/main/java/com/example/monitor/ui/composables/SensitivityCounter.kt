package com.example.monitor.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.common_composables.SpacerVertical
import com.example.ui.theme.AppTypography
import com.example.ui.theme.Colors
import com.example.ui.theme.Colors.GreyMonitor
import com.example.ui.theme.MahleTheme
import com.example.ui.theme.UiConstants

@Composable
fun SensitivityCounter(
    modifier: Modifier = Modifier,
    initialValue: Int = 0,
    step: Int = 10,
    max: Int = 100
) {
    var value by remember { mutableStateOf(initialValue.coerceIn(0, max)) }
    Column {
        Card(
            modifier = modifier,
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .padding(UiConstants.screenMarginS)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Power Assists",
                    modifier = Modifier.align(Alignment.Start),
                    style = AppTypography.bodyMedium
                )

                SpacerVertical(UiConstants.componentSpacing)

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFB1B1B1))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(value / max.toFloat())
                            .background(Color(0xFF4197E6)) // blue color
                    )
                    Text(
                        text = "$value %",
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
        SpacerVertical(UiConstants.componentSpacing)

        LevelControl(
            color = Colors.SmartAssist,
            onIncreaseLevel = { value = (value + step).coerceIn(0, max) },
            onDecreaseLevel = { value = (value - step).coerceIn(0, max) },
            isIncreaseEnabled = value < max,
            isDecreaseEnabled = value > 0
        )
    }
}


@Preview
@Composable
private fun PreviewSpeedSection() {
    MahleTheme {
        SensitivityCounter()
    }
}