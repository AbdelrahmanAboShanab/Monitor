package com.example.monitor.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.monitor.ui.theme.Colors.GreyMonitor
import com.mahle.ui.compose.theme.Shapes


fun getDarkColorPalette(primaryColorDark: Color): ColorScheme {
    return darkColorScheme(
        primary = primaryColorDark,
        onPrimary = Color.White,
        secondary = Colors.secondaryColor,
        onSecondary = Color.White,
        background = Colors.backgroundDark,
        onBackground = Color.White,
        surface = Colors.surfaceDark,
        surfaceContainer = Colors.surfaceDark,
        surfaceContainerHighest = Colors.surfaceDark,
        onSurface = Color.White,
        error = Colors.ErrorAlert,
        onError = Color.White
    )
}

fun getLightColorPalette(primaryColorLight: Color): ColorScheme {
    return lightColorScheme(
        primary = primaryColorLight,
        onPrimary = Color.White,
        secondary = Colors.secondaryColor,
        onSecondary = Color.White,
        background = Colors.backgroundLight,
        onBackground = Color.Black,
        surface = Colors.surfaceLight,
        surfaceContainer = Colors.surfaceLight,
        surfaceContainerHighest = Colors.surfaceLight,
        onSurface = Color.Black,
        error = Colors.ErrorAlert,
        onError = Color.White
    )
}
/**
 *    To add new color ->
 *      val ColorScheme.addNewColor: Color
 *      @Composable
 *      get() = if (isSystemInDarkTheme()) Color.Red else Color.Yellow
 *
 *      and in composable
 *      from composable  -> MaterialTheme.colorScheme.addNewColor
 */

val ColorScheme.floatingColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF0363B0) else Color(0xFF0363B0)

val ColorScheme.level0textColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF000000) else Color(0xFFFFFFFF)


val ColorScheme.monitorScreenTextColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.White else GreyMonitor


@Composable
fun MahleTheme(
    primaryColor: Color = Colors.primaryColor,
    primaryColorDark: Color = Colors.primaryColor,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        getDarkColorPalette(primaryColorDark)
    } else {
        getLightColorPalette(primaryColor)
    }

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        shapes = Shapes,
        content = content
    )
}