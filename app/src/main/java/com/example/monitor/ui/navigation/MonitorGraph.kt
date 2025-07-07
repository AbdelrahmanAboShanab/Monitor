package com.example.monitor.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.monitor.ui.main.MainScreen
import kotlinx.serialization.Serializable

@Serializable
object MonitorGraph

@Serializable
object MonitorRoute

fun NavGraphBuilder.monitorGraph() {
    navigation<MonitorGraph>(startDestination = MonitorRoute) {
        composable<MonitorRoute> {
            MainScreen()
        }
    }
}