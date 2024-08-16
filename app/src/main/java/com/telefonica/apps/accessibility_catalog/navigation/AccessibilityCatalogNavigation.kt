package com.telefonica.apps.accessibility_catalog.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.telefonica.apps.accessibility_catalog.dashboard.Dashboard
import com.telefonica.apps.accessibility_catalog.navigation.AccessibilityCatalogScreen.*


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
            Dashboard(
                navigateToDetail = actions.navigateToDetail
            )
        }
        composable(DETAIL_CLASSIC.name) {
            Text(text = "This is the detail composable screen!")
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
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
