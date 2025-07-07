package com.mahle.sbs.monitor.ui.common.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.monitor.ui.theme.AppTypography
import com.example.monitor.ui.theme.MahleTheme
import com.example.monitor.ui.theme.monitorScreenTextColor

@Composable
fun SpeedSection(
    speed: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .graphicsLayer(alpha = if (true) 1f else 0.4f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Speed",
                style = AppTypography.bodyMedium.copy(color = MaterialTheme.colorScheme.monitorScreenTextColor)
            )
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = speed.toString(),
                    style = AppTypography.displayLarge.copy(color = MaterialTheme.colorScheme.monitorScreenTextColor),
                )
                Text(
                    text = "km/h",
                    style = AppTypography.bodyMedium.copy(color = MaterialTheme.colorScheme.monitorScreenTextColor),
                    modifier = Modifier.padding(bottom = 8.dp, start = 4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSpeedSection() {
    MahleTheme {
        SpeedSection(
            speed =" 37.5f",
            modifier = Modifier.padding(12.dp)
        )
    }
}