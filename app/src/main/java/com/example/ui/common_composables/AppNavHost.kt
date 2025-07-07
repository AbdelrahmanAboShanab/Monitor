package com.example.ui.common_composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.monitor.ui.navigation.MonitorGraph
import com.example.monitor.ui.navigation.monitorGraph

@Composable
fun AppNavHost(modifier: Modifier, navController: NavHostController) {

    NavHost(navController = navController, startDestination = MonitorGraph, modifier = modifier) {
        monitorGraph()
    }

}