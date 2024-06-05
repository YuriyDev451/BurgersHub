package com.gukunov.burgershub.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gukunov.burgershub.presentation.BurgerList
import com.gukunov.burgershub.presentation.BurgerListScreen
import com.gukunov.burgershub.presentation.BurgerListViewModel

@Composable
fun HomeScreen(viewModel: BurgerListViewModel = hiltViewModel()) {
    val burgerList by viewModel.burgers.collectAsState(initial = emptyList())
    BurgerList(burgerList)
//    Box(
//        modifier = Modifier
//            .fillMaxWidth(),
//        contentAlignment = Alignment.Center
//    ) {
////        Text(
////            text = "Добро пожаловать в HomeScreen",
////            modifier = Modifier.padding(16.dp),
////            color = Color.Black,
////            fontSize = 20.sp,
////            fontWeight = FontWeight.Bold,
////            fontFamily = FontFamily.Serif
////        )
//        BurgerList(burgerList)
//    }

}