package com.example.monitor.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.theme.AppTypography
import com.example.ui.theme.MahleTheme
import com.example.ui.theme.monitorScreenTextColor

@Composable
fun MonitorGridItem(
    gridItem: GridItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.height(95.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 10.dp,
                vertical = 4.dp
            )
        ) {
            Text(
                text = gridItem.label,
                style = AppTypography.bodyMedium.copy(color = MaterialTheme.colorScheme.monitorScreenTextColor )
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = gridItem.value,
                    style = AppTypography.displaySmall.copy(color = MaterialTheme.colorScheme.monitorScreenTextColor)
                )
                if (gridItem.unit.isNotEmpty()) {
                    Text(
                        text = gridItem.unit,
                        style = AppTypography.bodyMedium.copy(color = MaterialTheme.colorScheme.monitorScreenTextColor),
                        modifier = Modifier.padding(start = 12.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewMonitorGridItem() {
    MahleTheme {
        MonitorGridItem(
            gridItem = GridItem("","",""),
            modifier = Modifier.width(160.dp)
        )
    }
}