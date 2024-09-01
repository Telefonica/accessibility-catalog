package com.telefonica.apps.accessibility_catalog.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.telefonica.apps.accessibility_catalog.navigation.AccessibilityCatalogScreen.DASHBOARD
import com.telefonica.apps.accessibility_catalog.navigation.AccessibilityCatalogScreen.DETAIL_CLASSIC
import com.telefonica.apps.accessibility_catalog.screens.DashboardScreen
import com.telefonica.apps.accessibility_catalog.screens.DetailScreen


enum class AccessibilityCatalogScreen {
    ON_BOARDING,
    DASHBOARD,
    DETAIL_CLASSIC,
    DETAIL_COMPOSE,
    HELP
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
        composable(DETAIL_CLASSIC.name) {
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
        navController.navigate(DETAIL_CLASSIC.name)
    }
    val backPress: () -> Unit = {
        navController.navigateUp()
    }
}
