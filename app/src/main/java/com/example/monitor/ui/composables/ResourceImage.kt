package com.example.monitor.ui.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun ResourceImage(
    @DrawableRes id: Int,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        colorFilter = colorFilter
    )
}