package com.example.monitor.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.monitor.R

val appFont = FontFamily(
    Font(R.font.exo_regular),
    Font(R.font.exo_medium),
    Font(R.font.exo_semibold),
    Font(R.font.exo_bold),
)

// Font weight = 400
val regularTextStyle = TextStyle(fontFamily = appFont, fontWeight = FontWeight.Normal)

// Font weight = 500
val mediumTextStyle = TextStyle(fontFamily = appFont, fontWeight = FontWeight.Medium)

// Font weight = 600
val semiBoldTextStyle = TextStyle(fontFamily = appFont, fontWeight = FontWeight.SemiBold)

// Font weight = 700
val boldTextStyle = TextStyle(fontFamily = appFont, fontWeight = FontWeight.Bold)

val AppTypography = Typography(
    displayLarge = semiBoldTextStyle.copy(fontSize = 96.sp),
    displayMedium = semiBoldTextStyle.copy(fontSize = 75.sp),
    displaySmall = semiBoldTextStyle.copy(fontSize = 48.sp),

    titleLarge = boldTextStyle.copy(fontSize = 30.sp),
    titleMedium = boldTextStyle.copy(fontSize = 20.sp),
    titleSmall = boldTextStyle.copy(fontSize = 18.sp),

    bodyLarge = regularTextStyle.copy(fontSize = 20.sp),
    bodyMedium = regularTextStyle.copy(fontSize = 16.sp),
    bodySmall = regularTextStyle.copy(fontSize = 14.sp),
)
