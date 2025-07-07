package com.example.monitor.bike

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.monitor.R
import com.example.monitor.core.AppButton
import com.example.monitor.core.SpacerVertical
import com.example.monitor.main.ActivityViewModel
import com.example.monitor.main.AssistanceLevel
import com.example.monitor.ui.theme.AppTypography
import com.example.monitor.ui.theme.Colors
import com.example.monitor.ui.theme.UiConstants
import com.example.monitor.ui.theme.mediumTextStyle
import com.example.monitor.ui.theme.MahleTheme
import com.example.monitor.ui.theme.level0textColor

@Composable
fun NoPulsometerScreen(viewModel: ActivityViewModel = viewModel()) {

    val uiState by viewModel.uiState.collectAsState()

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
        AssistanceLevel.LEVEL_4 -> Colors.SmartAssist
        else -> {
            Colors.AssistLevel0()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = UiConstants.screenMargin),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_no_pulsometer_body),
                    contentDescription = null
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_no_puslometer_up),
                        contentDescription = null
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_no_pulsometer_line),
                        contentDescription = null
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_no_puslometer_down),
                        contentDescription = null
                    )
                }

            }

            SpacerVertical(24.dp)

            Text(
                text = "There is no pulsometer band linked to the application",
                style = AppTypography.bodyLarge,
                modifier = Modifier.width(250.dp),
                textAlign = TextAlign.Center
            )
        }

        val appButtonTextColor = if(uiState.level == AssistanceLevel.LEVEL_0) MaterialTheme.colorScheme.level0textColor else Color.White
        AppButton(
            text = "Link pulsometer",
            iconId = R.drawable.ic_link_pulsometer,
            bgColor = levelColor,
            onClick = { viewModel.toggleTracking() },
            textStyle = mediumTextStyle.copy(fontSize = 16.sp, color = appButtonTextColor),
            iconTint = if(uiState.level == AssistanceLevel.LEVEL_0) MaterialTheme.colorScheme.level0textColor else Color.White
        )
        SpacerVertical(24.dp)
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewPage() {
    MahleTheme {
        NoPulsometerScreen()
    }
}