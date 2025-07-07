package com.example.ui.common_composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.monitor.R
import com.example.ui.theme.Colors
import com.example.ui.theme.mediumTextStyle
import com.example.ui.theme.MahleTheme


@Composable
fun AppButton(
    text: String,
    modifier: Modifier = Modifier,
    height: Int = 50,
    enabled: Boolean = true,
    @DrawableRes iconId: Int? = null,
    iconTint: Color? = null,
    bgColor: Color? = null,
    disabledBgColor: Color? = null,
    disabledTextColor: Color? = null,
    textStyle: TextStyle? = null,
    onClick: () -> Unit
) {
    val disabledBackground = disabledBgColor ?: bgColor?.copy(alpha = 0.25f)
    ?: MaterialTheme.colorScheme.primary.copy(alpha = 0.25f)

    val colors = ButtonDefaults.buttonColors().copy(
        containerColor = bgColor ?: MaterialTheme.colorScheme.primary,
        disabledContainerColor = disabledBackground,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        disabledContentColor = disabledTextColor ?: MaterialTheme.colorScheme.onPrimary
    )

    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(height.dp),
        colors = colors,
        enabled = enabled,
        shape = RoundedCornerShape(5.dp)
    ) {
        if (iconId != null) {
            val tint = if (iconTint == null){
                if (enabled) colors.contentColor else colors.disabledContentColor
            }else  {
                iconTint
            }
            IconColored(
                drawableId = iconId,
                tint = tint
            )
            SpacerHorizontal(size = 12.dp)
        }
        if (textStyle == null) {
            val newTextStyle = if (disabledTextColor != null && !enabled) {
                mediumTextStyle.copy(fontSize = 16.sp, color = disabledTextColor)
            } else {
                mediumTextStyle.copy(fontSize = 16.sp)
            }
            Text(text = text, style = newTextStyle)

        } else {
            Text(text = text, style = textStyle)
        }
    }
}

@Composable
fun IconButtonWithRadius(
    modifier: Modifier,
    onClick: () -> Unit,
    image: Int,
    iconTint: Color = Color.White,
    backgroundColor: Color = Color.Blue,
    radius: Dp = 16.dp,
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(radius),
        color = backgroundColor,
        modifier = modifier
            .background(iconTint)
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = "Button icon",
            modifier = Modifier.size(24.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAppButton() {
    MahleTheme {
        Column(Modifier.padding(16.dp)) {
            AppButton(text = "Default", onClick = {})
            SpacerVertical(16.dp)
            AppButton(text = "Default Disabled", onClick = {}, enabled = false)
            SpacerVertical(16.dp)
            AppButton(
                text = "Button with icon",
                iconId = R.drawable.ic_create_account,
                onClick = {}
            )
            SpacerVertical(16.dp)
            AppButton(text = "Colored Button", onClick = {}, bgColor = Colors.LimeGreen)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewIconButtonWithRadius() {
    MahleTheme {
        IconButtonWithRadius(
            modifier = Modifier.padding(top = 5.dp),
            onClick = {},
            image = R.drawable.ic_import_route,
            radius = 5.dp,  // Half of 150dp
            backgroundColor = Color(0xFF0363B0)
        )
    }
}