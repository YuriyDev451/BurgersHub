package com.gukunov.burgershub.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
//import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import coil.compose.rememberAsyncImagePainter
//import coil.compose.rememberImagePainter
import com.gukunov.burgershub.domain.uiModel.BurgerUIState
import com.gukunov.burgershub.ui.theme.BurgersHubTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.lifecycleScope
import coil.compose.rememberImagePainter
import com.gukunov.burgershub.domain.entity.BurgerItem
import com.gukunov.burgershub.domain.uiModel.BurgerItemUIModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val burgerListViewModel: BurgerListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

            burgerListViewModel.getBurgerList()

        setContent {
            BurgerListScreen(burgerListViewModel)
        }
    }
}



@Composable
fun BurgerItem(burger: BurgerItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(burger.images),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        burger.name?.let { Text(text = it, style = MaterialTheme.typography.bodyMedium) }
    }
}

@Composable
fun BurgerListScreen(viewModel: BurgerListViewModel) {
    val burgers by viewModel.burgers.observeAsState()
    val bg = listOf("dfd", "gfggf", "sdfsdg", "etyhe", "wetrtwert", "vfdgre")
    LazyColumn {
 //       burgers?.let {
            items(burgers!!) {
                BurgerItem(it)
            }
//        }
    }
}





//@Composable
//fun MyScreen(viewModel: BurgerListViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
//    val data by viewModel.burgers.observeAsState(emptyList())
//
//    LazyColumn {
//        items(data) { item ->
//            MyCard(item)
//        }
//    }
//}
//
//@Composable
//fun MyCard(item: BurgerUIState) {
//    Card(
//        modifier = Modifier
//            .padding(8.dp)
//            .fillMaxWidth(),
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Image(
//                painter = rememberImagePainter(data = item.burgers.firstOrNull()?.images),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(64.dp)
//                    .clip(CircleShape)
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            item.burgers.firstOrNull()?.name?.let {
//                Text(
//                    text = it,
//                    style = MaterialTheme.typography.bodyMedium
//                )
//            }
//        }
//    }
//}
//
//




//@Composable
//fun BurgerItem(burger: BurgerUIState) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Image(
//            painter = rememberImagePainter(burger.burgers.firstOrNull()?.images),
//            contentDescription = null,
//            modifier = Modifier
//                .size(64.dp)
//                .clip(CircleShape)
//                .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
//        )
//        Spacer(modifier = Modifier.width(16.dp))
//        burger.burgers.firstOrNull()?.name?.let { Text(text = it, style = MaterialTheme.typography.bodyMedium) }
//    }
//}
//
//@Composable
//fun BurgerListScreen(viewModel: BurgerListViewModel = hiltViewModel()) {
//    val burgersState by viewModel.burgers.observeAsState(BurgerUIState.Loading)
//
//    when (burgersState) {
//        is BurgerUIState.Loading -> {
//            // Отображение индикатора загрузки
//            CircularProgressIndicator()
//        }
//        is BurgerUIState.Success -> {
//            val burgers = (burgersState as BurgerUIState.Success).burgers
//            LazyColumn {
//                items(burgers) { burger ->
//                    BurgerItem(burger = burger)
//                }
//            }
//        }
//        is BurgerUIState.Error -> {
//            // Отображение сообщения об ошибке
//            Text(text = "Ошибка: ${(burgersState as BurgerUIState.Error).message}")
//        }
//    }
//
//    LaunchedEffect(Unit) {
//        viewModel.getBurgerList()
//    }
//}


//
//@Composable
//fun BurgerCardList(burgers: List<BurgerUIState>) {
//    LazyColumn {
//        items(burgers) { burger ->
//            BurgerListItem(burger)
//        }
//    }
//}
//
//
//@Composable
//fun BurgerListItem(item: BurgerUIState) {
//    Card(
//        modifier = Modifier
//            .padding(8.dp)
//            .fillMaxWidth(),
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
//
//    ) {
////        Row(
////            modifier = Modifier
////                .padding(16.dp)
////                .fillMaxWidth(),
////            verticalAlignment = Alignment.CenterVertically
////        ) {
////
////        }
//        Box(
//        ) {
//            Row {
//                Image(
//                    painter = rememberAsyncImagePainter(model = item.burgers.firstOrNull()?.images),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop
//                )
//                Spacer(modifier =  Modifier.height(8.dp))
//                item.burgers.firstOrNull()?.name?.let { Text(text = it, style = MaterialTheme.typography.bodyMedium) }
//            }
//        }
//    }
//}
//
//@Composable
//fun BurgerListScreen(viewModel: BurgerListViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
//    val burgerUIState by viewModel.burgers.observeAsState(BurgerUIState(emptyList()))
//
//}
//
////@Composable
////fun BurgerListScreen(viewModel: BurgerListViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
////    val burgers = viewModel.burgers
////
////
////    Column(
////        modifier = Modifier.fillMaxSize(),
////        verticalArrangement = Arrangement.Center,
////        horizontalAlignment = Alignment.CenterHorizontally
////    ) {
////        Button(onClick = {
////            viewModel.getBurgerList()
////        }) {
////            Text(text = "Load Burgers")
////        }
////
////        // Display burger data
////        burgers.value?.let { burgerResponse ->
////            // Replace this with your UI to display the burgers
////            Text(text = burgerResponse.toString())
////        }
////    }
////}



