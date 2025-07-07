package com.example.monitor.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.common_composables.SpacerVertical
import com.example.ui.theme.UiConstants.componentSpacing
import com.example.ui.theme.MahleTheme

@Composable
fun MonitorGrid(
    isRecordingActivity: Boolean = false,
    modifier: Modifier = Modifier,
    items: List<GridItem>
) {
    Column(
        modifier = modifier
    ) {
        for (i in items.chunked(2)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MonitorGridItem(
                    i.get(0),
                    modifier = Modifier
                        .weight(1f)
                )
                MonitorGridItem(
                    i.get(1),
                    modifier = Modifier
                        .weight(1f)
                )
            }
            SpacerVertical(componentSpacing)
        }
    }
}

@Preview
@Composable
private fun PreviewSpeedSection() {
    MahleTheme {
//        MonitorGrid(
//            modifier = Modifier,
//            isEnabled = true
//        )
    }
}