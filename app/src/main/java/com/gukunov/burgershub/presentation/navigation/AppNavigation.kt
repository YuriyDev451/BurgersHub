package com.gukunov.burgershub.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gukunov.burgershub.presentation.BurgerListScreen
import com.gukunov.burgershub.presentation.screens.FavoriteScreen
import com.gukunov.burgershub.presentation.screens.HomeScreen
import com.gukunov.burgershub.presentation.screens.ProfileScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        NavigationBar  {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            listOfNavItem.forEach {navItem ->
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any {
                        it.route == navItem.route } == true,
                    onClick = {
                        navController.navigate(navItem.route){
                            popUpTo(navController.graph.startDestinationId){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true

                        }
                              },
                    icon = {Icon(imageVector = navItem.icon, contentDescription = null)},
                    label ={
                        Text(text = navItem.label)
                    }
                )
            }

        }

    }) {
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen.name,
            modifier = Modifier
                .padding(it)
        ) {
            composable(route = Screens.HomeScreen.name) {
                //HomeScreen()
                BurgerListScreen()
            }
            composable(route = Screens.FavoriteScreen.name) {
                FavoriteScreen()
            }
            composable(route = Screens.ProfileScreen.name) {
                ProfileScreen()
            }
        }
    }
}