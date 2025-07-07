package com.example.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

/**
 * Design tokens for the application.
 * This class holds default design values to maintain consistency across the app.
 */
object UiConstants {
    // Base spacing unit
    val grid = 4.dp

    // Screen margins
    val screenMarginS = 12.dp
    val screenMargin = 16.dp
    val screenMarginL = 20.dp

    // Component spacing
    val componentSpacingXXS = 2.dp
    val componentSpacingXS = 4.dp
    val componentSpacingS = 8.dp
    val componentSpacing = 12.dp
    val componentSpacingL = 16.dp
    val componentSpacingXL = 20.dp
    val componentSpacingXXL = 32.dp
    val componentSpacingXXXL = 42.dp

    // Content padding
    val contentPaddingS = 8.dp
    val contentPadding = 16.dp
    val contentPaddingL = 24.dp

    val roundedCornerShape = RoundedCornerShape(5.dp)
    val roundedCornerShapeL = RoundedCornerShape(8.dp)

    val radiusDefault = 5.dp

    /**
     * Elevation values for components.
     */
    object Elevation {
        val none = 0.dp
        val small = 2.dp
        val medium = 4.dp
        val large = 8.dp
    }
}