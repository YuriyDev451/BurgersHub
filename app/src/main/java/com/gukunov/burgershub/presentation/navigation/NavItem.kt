package com.gukunov.burgershub.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String

)

val listOfNavItem = listOf(
    NavItem(
        label = "Home",
        icon = Icons.Default.Home,
        route = Screens.HomeScreen.name
    ),
    NavItem(
        label = "Favorite",
        icon = Icons.Default.Favorite,
        route = Screens.FavoriteScreen.name
    ),
    NavItem(
        label = "Settings",
        icon = Icons.Default.Settings,
        route = Screens.ProfileScreen.name
    )
)

