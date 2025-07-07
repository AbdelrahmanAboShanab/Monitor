package com.example.monitor.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object Colors {

    val primaryColor = Color(0xFF0463B1)
    val secondaryColor = Color(0xFF41B5E6)
    val backgroundLight = Color(0xFFFAFAFA)
    val backgroundDark = Color(0xFF33383E)
    val surfaceLight = Color(0xFFFFFFFF)
    val surfaceDark = Color(0xFF1D1E26)

    // Assistant Levels
    @Composable
    fun AssistLevel0(): Color =
        if (isSystemInDarkTheme()) Color(0xFFE6E6E6) else Color(0xFF2D2D2D)

    @Composable
    fun AssistLevel3(): Color =
        if (isSystemInDarkTheme()) Color(0xFFDB65EE) else Color(0xFFAB2BC0)


    val AssistLevel1 = Color(0xFF42B029)
    val AssistLevel2 = Color(0xFFF39A3E)
    val SmartAssist = Color(0xFF4197E6)
    val AssistLevelAutoHR = Color(0xFFD8143B)

    // Greys
    val Grey2D = Color(0xFF2D2D2D)
    val Grey63 = Color(0xFF636363)
    val Grey86 = Color(0xFF868686)
    val GreyE4 = Color(0xFFE4E4E4)
    val GreyFA = Color(0xFFFAFAFA)
    val GreyMonitor = Color(0xFF676878)
    val GreyMonitorDisable = Color(0xFFB1B1B1)
    val GreyCardBorder = Color(0xFF404040)

    // Brand Themes
    val MahleBlue = Color(0xFF102665)
    val ElectricBlue = Color(0xFF1A58AD)
    val Aquamarine = Color(0xFF0D8699)
    val SkyBlue = Color(0xFF00A2E2)
    val Turquoise = Color(0xFF21BBBB)
    val LimeGreen = Color(0xFF7FBA00)
    val Purple = Color(0xFF932689)
    val CrimsonRed = Color(0xFFA81111)
    val PassionRed = Color(0xFFD4111A)
    val Flamingo = Color(0xFFFF3358)
    val Monochrome = Color(0xFF000000)
    val GoldenBrown = Color(0xFFB59251)
    val Gold = Color(0xFFF7B913)

    // Status
    val ErrorAlert = Color(0xFFBA0C2F)
    val StatusOk = Color(0xFF42B029)
    val Medium = Color(0xFFF2D03E)

    // Graph
    val GraphBlue = Color(0xFF56BAC5)
    val GraphGreen = Color(0xFF42B029)
    val GraphPink = Color(0xFFFD8585)
    val GraphYellow = Color(0xFFF2D03E)
    val GraphOrange = Color(0xFFF39A3E)
    val GraphGridLine = Color(0xFFC0C0C0)


    //Tab You
    val UnselectedTextTab = Color(0xFF716E6E)
    val SeparatorTab = Color(0xFF404040)
}