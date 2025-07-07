package com.example.monitor.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
object HomeGraph

@Serializable
object HomeRoute

fun NavGraphBuilder.homeGraph() {
    navigation<HomeGraph>(startDestination = HomeRoute) {
        composable<HomeRoute> {
            Box(Modifier.fillMaxSize()) {
                Text(text = "Home Screen", Modifier.align(Alignment.Center))
            }
        }
    }
}