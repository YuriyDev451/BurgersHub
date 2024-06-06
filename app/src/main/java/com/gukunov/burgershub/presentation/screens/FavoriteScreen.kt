package com.gukunov.burgershub.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.gukunov.burgershub.presentation.BurgerItemView
import com.gukunov.burgershub.presentation.BurgerListViewModel
import com.gukunov.burgershub.presentation.navigation.AppNavigation
import com.gukunov.burgershub.presentation.navigation.BottomNavigationBar


@Composable
fun FavoriteScreen(viewModel: BurgerListViewModel) {


    val favoriteBurgers by viewModel.favoriteBurgers.collectAsState()


    if (favoriteBurgers.isEmpty()) {
        Text(text = "Нет избранных бургеров", modifier = Modifier.padding(16.dp))
    }
    else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(favoriteBurgers) { burger ->
                BurgerItemView(burger, viewModel)
            }
        }
    }


//    Box(
//        modifier = Modifier
//            .fillMaxWidth(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = "Добро пожаловать в FavoriteScreen",
//            modifier = Modifier.padding(16.dp),
//            color = Color.Black,
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            fontFamily = FontFamily.Serif
//        )
//    }
}





















//    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun MainS(burgerListViewModel: BurgerListViewModel) {

        val navController = rememberNavController()

        Scaffold(
            bottomBar = { BottomNavigationBar(navController) },
            content = {
                Box (modifier = Modifier.padding(it)){
                    AppNavigation(navController = navController, burgerListViewModel)
                }

            }



        )
    }


//    Box(
//        modifier = Modifier
//            .fillMaxWidth(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = "Добро пожаловать в FavoriteScreen",
//            modifier = Modifier.padding(16.dp),
//            color = Color.Black,
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            fontFamily = FontFamily.Serif
//        )
//    }
