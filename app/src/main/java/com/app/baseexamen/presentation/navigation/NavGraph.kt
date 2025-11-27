package com.app.baseexamen.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.baseexamen.presentation.screens.main.HomeScreen

sealed class Screen(
    val route: String,
){
    object Home : Screen("home")
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun NavGraph (
    modifier: Modifier = Modifier,
    navController: NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier,
    ){
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
    }
}