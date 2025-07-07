package com.example.monitor.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavHost(modifier: Modifier, navController: NavHostController) {

    NavHost(navController = navController, startDestination = MonitorGraph, modifier = modifier) {
        homeGraph()
        monitorGraph()
    }

}