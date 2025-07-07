package com.example.monitor.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.MahleTheme

@Composable
fun LevelControl(
    color: Color,
    onIncreaseLevel: () -> Unit,
    onDecreaseLevel: () -> Unit,
    modifier: Modifier = Modifier,
    isIncreaseEnabled: Boolean = true,
    isDecreaseEnabled: Boolean = true
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        LevelControlButton(
            text = "−",
            color = color,
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
                .clickable(enabled = isDecreaseEnabled) { onDecreaseLevel() },
            isEnabled = isDecreaseEnabled
        )

        LevelControlButton(
            text = "+",
            color = color,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
                .clickable(enabled = isIncreaseEnabled) { onIncreaseLevel() },
            isEnabled = isIncreaseEnabled
        )
    }
}

@Composable
fun LevelControlButton(
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {

    Box(
        modifier = modifier
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(5.dp)
            )
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = color
        )
    }
}

@Preview
@Composable
private fun PreviewLevelControlButton() {
    MahleTheme {
        LevelControlButton(
            text = "+",
            color = Color.Gray,
            modifier = Modifier
                .padding(12.dp)
                .size(60.dp)
        )
    }

}