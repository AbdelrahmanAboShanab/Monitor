package com.example.monitor.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.example.monitor.core.AppNavHost
import com.example.monitor.ui.theme.MahleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            // Provide the brand manager to the composition down the tree

            MahleTheme {
                val navController = rememberNavController()
                Scaffold(
                ) { innerPadding ->
                    AppNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController
                    )
                }
            }
            SetStatusBarColor()
        }
    }


    @Composable
    private fun SetStatusBarColor() {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

            val contentColor = MaterialTheme.colorScheme.surface
            statusBarColor = contentColor.toArgb()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.decorView.windowInsetsController?.setSystemBarsAppearance(
                    if (isSystemInDarkTheme()) {
                        0
                    } else {
                        WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                    }, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                )
            }
        }
    }

    override fun attachBaseContext(newBase: Context) {
        val MAX_TEXT_SCALE = 1.33f
        val MAX_DISPLAY_SCALE = 440

        val configuration = Configuration(newBase.resources?.configuration)
        if (configuration.fontScale > MAX_TEXT_SCALE) {
            configuration.fontScale = MAX_TEXT_SCALE
        }
        if (configuration.densityDpi > MAX_DISPLAY_SCALE) {
            configuration.densityDpi = MAX_DISPLAY_SCALE
        }

        val context = newBase.createConfigurationContext(configuration)
        super.attachBaseContext(context)
    }

}