package com.telefonica.apps.accessibility_catalog.view.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.telefonica.apps.accessibility_catalog.view.screens.DashboardScreen
import com.telefonica.apps.accessibility_catalog.view.screens.DetailScreen
import com.telefonica.apps.accessibility_catalog.view.screens.ImplementationScreen
import java.util.UUID

private const val ID_ARGUMENT = "id_argument"

abstract class AccessibilityCatalogDestination(val simpleRoute: String)

object OnBoarding : AccessibilityCatalogDestination(simpleRoute = "on_boarding")
object Dashboard : AccessibilityCatalogDestination(simpleRoute = "dashboard")
object Detail : AccessibilityCatalogDestination(simpleRoute = "detail") {
    val routeWithArg = "${simpleRoute}/{${ID_ARGUMENT}}"
    val arguments = listOf(
        navArgument(ID_ARGUMENT) { type = NavType.StringType }
    )
}

object Implementation : AccessibilityCatalogDestination(simpleRoute = "implementation") {
    val routeWithArg = "${simpleRoute}/{${ID_ARGUMENT}}"
    val arguments = listOf(
        navArgument(ID_ARGUMENT) { type = NavType.StringType }
    )
}

object Help : AccessibilityCatalogDestination(simpleRoute = "help")

@Composable
fun AccessibilityCatalogNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Dashboard.simpleRoute,
        enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(700)) },
        exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(700)) },
        popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(700)) },
        popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(700)) }
    ) {
        composable(Dashboard.simpleRoute) {
            DashboardScreen(
                navigateToDetail = { elementId ->
                    navController.navigateSingleTopToWithIdArgument(Detail.simpleRoute, elementId.toString())
                }
            )
        }

        composable(
            route = Detail.routeWithArg,
            arguments = Detail.arguments,
        ) { navBackStackEntry ->
            val idArgument = navBackStackEntry.arguments?.getString(ID_ARGUMENT)
            DetailScreen(
                elementId = UUID.fromString(idArgument),
                onBackPressed = { navController.navigateUp() },
                onImplementationClick = { elementId ->
                    navController.navigateSingleTopToWithIdArgument(Implementation.simpleRoute, elementId.toString())
                }
            )
        }

        composable(
            route = Implementation.routeWithArg,
            arguments = Implementation.arguments,
            enterTransition = { slideInVertically(initialOffsetY = { 1800 }) },
            exitTransition = { slideOutVertically(targetOffsetY = { 1800 }) },
        ) { navBackStackEntry ->
            val idArgument = navBackStackEntry.arguments?.getString(ID_ARGUMENT)
            ImplementationScreen(
                elementId = UUID.fromString(idArgument),
                onCloseClick = { elementId ->
                    //todo check nav flow -> navController.navigateUp()
                    navController.navigateSingleTopToWithIdArgument(Detail.simpleRoute, elementId.toString())
                }
            )
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

private fun NavHostController.navigateSingleTopToWithIdArgument(route: String, idArgument: String) {
    this.navigateSingleTopTo("${route}/$idArgument")
}
