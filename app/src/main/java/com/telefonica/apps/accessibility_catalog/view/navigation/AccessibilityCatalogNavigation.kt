package com.telefonica.apps.accessibility_catalog.view.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.telefonica.apps.accessibility_catalog.view.navigation.AccessibilityCatalogScreen.DASHBOARD
import com.telefonica.apps.accessibility_catalog.view.navigation.AccessibilityCatalogScreen.DETAIL
import com.telefonica.apps.accessibility_catalog.view.screens.DashboardScreen
import com.telefonica.apps.accessibility_catalog.view.screens.DetailScreen

enum class AccessibilityCatalogScreen {
    ON_BOARDING,
    DASHBOARD,
    DETAIL,
    IMPLEMENTATION,
    HELP,
}

@Composable
fun AccessibilityCatalogNavHost(
    navController: NavHostController = rememberNavController(),
) {
    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = DASHBOARD.name,
        enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(700)) },
        exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(700)) },
        popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(700)) },
        popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(700)) }
    ) {
        composable(DASHBOARD.name) {
            DashboardScreen(
                navigateToDetail = actions.navigateToDetail
            )
        }
        composable(DETAIL.name) {
            DetailScreen(
                onBackPressed = actions.backPress
            )
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val navigateToDetail: () -> Unit = {
        navController.navigate(DETAIL.name)
    }
    val backPress: () -> Unit = {
        navController.navigateUp()
    }
}
