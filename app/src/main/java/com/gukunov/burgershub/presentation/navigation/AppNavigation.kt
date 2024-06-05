package com.gukunov.burgershub.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gukunov.burgershub.presentation.BurgerList
import com.gukunov.burgershub.presentation.BurgerListScreen
import com.gukunov.burgershub.presentation.BurgerListViewModel
import com.gukunov.burgershub.presentation.screens.FavoriteScreen
import com.gukunov.burgershub.presentation.screens.HomeScreen
import com.gukunov.burgershub.presentation.screens.ProfileScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.name
    ) {
        composable(route = Screens.HomeScreen.name) {
            HomeScreen()
            //BurgerListScreen()
        }
        composable(route = Screens.FavoriteScreen.name) {
            FavoriteScreen()
        }
        composable(route = Screens.ProfileScreen.name) {
            ProfileScreen()
        }
    }


}

//    val navController = rememberNavController()
//
//    Scaffold(topBar = {
//        CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = Color(0xFFEBE698),
//            titleContentColor = MaterialTheme.colorScheme.primary
//        ),
//            modifier = modifier.clip(
//                RoundedCornerShape(
//                    bottomStart = 16.dp,
//                    bottomEnd = 16.dp
//                )
//            ),
//            title = {
//                Text(
//                    text = "BurgersHub",
//                    fontSize = 24.sp,
//                    color = MaterialTheme.colorScheme.primary
//                )
//
//            })
//    },
//        content = {
//        NavHost(
//            navController = navController,
//            startDestination = Screens.HomeScreen.name
//        ) {
//            composable(route = Screens.HomeScreen.name) {
//                HomeScreen()
//                //BurgerListScreen()
//            }
//            composable(route = Screens.FavoriteScreen.name) {
//                FavoriteScreen()
//            }
//            composable(route = Screens.ProfileScreen.name) {
//                ProfileScreen()
//            }
//        }},
//        bottomBar = {
//            NavigationBar(
//                modifier = Modifier.navigationBarsPadding(), containerColor = Color(0xFFC8FABB)
//            ) {
//                val navBackStackEntry by navController.currentBackStackEntryAsState()
//                val currentDestination = navBackStackEntry?.destination
//
//                listOfNavItem.forEach { navItem ->
//                    NavigationBarItem(
//                        selected = currentDestination?.hierarchy?.any {
//                            it.route == navItem.route
//                        } == true,
//                        onClick = {
//                            navController.navigate(navItem.route) {
//                                popUpTo(navController.graph.startDestinationId) {
//                                    saveState = true
//                                }
//                                launchSingleTop = true
//                                restoreState = true
//
//                            }
//                        },
//                        icon = { Icon(imageVector = navItem.icon, contentDescription = null) },
//                        label = {
//                            Text(text = navItem.label)
//                        }
//                    )
//                }
//
//            }
//
//        })
