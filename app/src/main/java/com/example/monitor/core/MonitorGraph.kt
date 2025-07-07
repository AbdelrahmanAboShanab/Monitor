package com.example.monitor.core

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.monitor.main.MainScreen
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