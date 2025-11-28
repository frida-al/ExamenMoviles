package com.app.baseexamen.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.app.baseexamen.presentation.screens.detail.DetailScreen
import com.app.baseexamen.presentation.screens.main.HomeScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")

    object Detail : Screen("detail/{country}") {
        fun createRoute(country: String) = "detail/${country.lowercase()}"
    }
}



@Suppress("ktlint:standard:function-naming")
@Composable
fun NavGraph (
    modifier: Modifier = Modifier,
    navController: NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Detail.route) { backStackEntry ->
            val country = backStackEntry.arguments?.getString("country") ?: ""
            DetailScreen(
                navController = navController,
                country = country
            )
        }
    }

}