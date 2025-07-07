package com.example.monitor.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.monitor.core.SpacerHorizontal
import com.example.monitor.ui.theme.UiConstants
import kotlinx.coroutines.launch

@Composable
fun MonitorScreenIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    showArrows: Boolean = true,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = MaterialTheme.colorScheme.onBackground,
    indicatorSpacing: Dp = 8.dp
) {
    val coroutineScope = rememberCoroutineScope()
    Row(
        modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = UiConstants.componentSpacingS),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (showArrows) {
            Box(Modifier.size(24.dp)) {
                if (pagerState.currentPage > 0) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Previous page",
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                }
                            }
                    )
                }
            }
        }

        SpacerHorizontal(UiConstants.componentSpacingS)

        repeat(pagerState.pageCount) { iteration ->
            val color =
                if (pagerState.currentPage == iteration) selectedColor
                else unselectedColor
            val size = if (pagerState.currentPage == iteration) 10.dp else 8.dp
            Box(
                modifier = Modifier
                    .padding(horizontal = indicatorSpacing / 2)
                    .clip(CircleShape)
                    .background(color)
                    .size(size)
            )
        }

        SpacerHorizontal(UiConstants.componentSpacingS)

        if (showArrows) {
            Box(Modifier.size(24.dp)) {
                if (pagerState.currentPage < pagerState.pageCount - 1) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Next page",
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                }
                            }
                    )
                }
            }
        }
    }
}