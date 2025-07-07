package com.example.monitor.core

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IconColored(
    @DrawableRes drawableId: Int,
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    tint: Color = Color.Unspecified,
    onClick: (() -> Unit)? = null
) {
    val mod =
        if (onClick == null) {
            modifier
        } else {
            modifier
                .size(size)
                .clickable(
                    onClick = onClick,
                    role = Role.Button,
                    interactionSource = null,
                    indication = ripple(bounded = false, radius = size)
                )
        }

    Icon(
        painter = painterResource(id = drawableId),
        contentDescription = "",
        tint = tint,
        modifier = mod
    )
}