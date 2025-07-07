package com.example.monitor.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.monitor.bike.MonitorBikeScreen
import com.example.monitor.core.SpacerVertical
import com.example.monitor.ui.theme.Colors
import com.example.monitor.ui.theme.UiConstants.componentSpacingS
import com.example.monitor.ui.theme.UiConstants.componentSpacingXS
import com.example.monitor.ui.theme.UiConstants.screenMargin
import com.example.monitor.ui.composables.MonitorHeader
import com.example.monitor.ui.composables.MonitorScreenIndicator
import com.example.monitor.bike.NoPulsometerScreen
import com.example.monitor.ui.theme.MahleTheme
import com.example.monitor.ui.theme.level0textColor


@Composable
fun MainScreen(viewModel: ActivityViewModel = viewModel()) {

    val uiState by viewModel.uiState.collectAsState()
    val pagerState = rememberPagerState(pageCount = { 3 })

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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = screenMargin)
        ) {
            MonitorHeader(
                modifier = Modifier.fillMaxWidth().padding(horizontal = screenMargin),
                level = uiState.level.stringText,
                color = levelColor,
                textColor = if (uiState.level == AssistanceLevel.LEVEL_0) MaterialTheme.colorScheme.level0textColor else Color.White
            )

            HorizontalPager(
                state = pagerState,
                beyondViewportPageCount = 2,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { page ->
                when (page) {
                    0 -> {
                        MonitorBikeScreen(viewModel = viewModel)
                    }
                    1 -> {
                        NoPulsometerScreen(viewModel = viewModel)
                    }
                    2 -> {
                        Text("Third Screen", modifier = Modifier.fillMaxSize())
                    }
                }
            }

            SpacerVertical(componentSpacingXS)

            MonitorScreenIndicator(
                pagerState = pagerState,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                showArrows = false,
                selectedColor = Color.Black,
                unselectedColor = Colors.GreyMonitor,
                indicatorSpacing = 14.dp
            )
            SpacerVertical(componentSpacingS)
        }

}


@Preview(showBackground = true)
@Composable
private fun PreviewPage() {
    MahleTheme {
        MainScreen()
    }
}