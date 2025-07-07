package com.example.monitor.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.monitor.R
import com.example.ui.common_composables.ResourceImage
import com.example.ui.theme.Colors
import com.example.ui.theme.MahleTheme

@Composable
fun MonitorHeader(
    modifier: Modifier = Modifier,
    level: String,
    color: Color,
    textColor: Color = Color.White
    ) {
    Row(
        modifier = modifier
            .height(60.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            ResourceImage(
                modifier = Modifier.fillMaxSize(),
                id = R.drawable.bg_assist_level_header,
                contentScale = ContentScale.FillBounds,
                colorFilter = ColorFilter.tint(color)
            )

            Box(
                Modifier
                    .background(color = color)
                    .height(4.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            )

            Text(
                text = level,
                color = textColor,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Column(
            Modifier
                .width(40.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Icon(
                modifier = Modifier
                    .width(28.dp)
                    .weight(1f),
                imageVector = Icons.Outlined.Info,
                tint = MaterialTheme.colorScheme.onSurface,
                contentDescription = "Info",
            )
            Box(
                Modifier
                    .background(color = color)
                    .height(4.dp)
                    .fillMaxWidth()
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewMonitorHeader() {
    MahleTheme {
        MonitorHeader(
            Modifier.padding(12.dp),
            level = "2",
            color = Colors.AssistLevel2
        )
    }
}