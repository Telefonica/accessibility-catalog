package com.telefonica.apps.accessibility_catalog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.telefonica.apps.accessibility_catalog.dashboard.Dashboard
import com.telefonica.apps.accessibility_catalog.navigation.AccessibilityCatalogScreen.*

enum class AccessibilityCatalogScreen() {
    ON_BOARDING,
    DASHBOARD,
    DETAIL,
    HELP
}

@Composable
fun AccessibilityCatalogNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = DASHBOARD.name,
    ) {
        composable(DASHBOARD.name) {
            Dashboard()
        }
    }
}