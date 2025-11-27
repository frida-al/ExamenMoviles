package com.app.baseexamen.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavDestination (
    val route: String,
    val label: String,
    val icon: ImageVector,
    val filledIcon: ImageVector? = null
){
    object Home : NavDestination(
        route = "home",
        label = "Inicio",
        icon = Icons.Outlined.Home,
        filledIcon = Icons.Filled.Home)
    companion object {
        val items = listOf(Home)
    }
}