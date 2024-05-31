package com.gukunov.burgershub.presentation

import android.content.res.Resources.Theme
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
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.gukunov.burgershub.domain.entity.BurgerItem
import com.gukunov.burgershub.domain.uiModel.BurgerItemUIModel
import com.gukunov.burgershub.presentation.navigation.AppNavigation
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //BurgerListScreen()
//Theme
//            Scaffold {
//
//            }
            AppNavigation()


        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BurgerListScreen(viewModel: BurgerListViewModel = hiltViewModel()) {
    val burgerList by viewModel.burgers.collectAsState(initial = emptyList())
//    BurgerList(burgers = burgerList)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier.clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)),
                title = {
                    Text(
                        text = "BurgersHub",
                        fontSize = 24.sp,
                        color = MaterialTheme.colorScheme.primary)

                })
        },
//        bottomBar = {
////            BottomAppBar(
////                modifier = Modifier,
////                actions = {
////                    Row(modifier = Modifier.fillMaxWidth(),
////                        horizontalArrangement = Arrangement.SpaceEvenly,
////                        verticalAlignment = Alignment.CenterVertically) {
////                        IconButton(onClick = { /* do something */ }) {
////                            Icon(Icons.Filled.Home, contentDescription = "Localized description")
////                        }
////                        IconButton(onClick = { /* do something */ }) {
////                            Icon(
////                                Icons.Filled.Favorite,
////                                contentDescription = "Localized description",
////                            )
////                        }
////                        IconButton(onClick = { /* do something */ }) {
////                            Icon(
////                                Icons.Filled.Settings,
////                                contentDescription = "Localized description",
////                            )
////                        }
////                        IconButton(onClick = { /* do something */ }) {
////                            Icon(
////                                Icons.Filled.Share,
////                                contentDescription = "Localized description",
////                            )
////                        }
////                    }
////
////                })
//        },
        content = {
            BurgerList(burgers = burgerList, modifier = Modifier.padding(it))
        }
    )


}

@Composable
fun BurgerList(burgers: List<BurgerItem>?, modifier: Modifier = Modifier) {
    burgers?.let {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 8.dp, bottom = 30.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(burgers) { burger ->
                BurgerItemView(burger)
            }
        }
    }
}

@Composable
fun BurgerItemView(burger: BurgerItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 10.dp, top = 10.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

    ) {
        Image(
            painter = rememberImagePainter(burger.images.firstOrNull()?.sm),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        burger.name?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            )
        }
    }
}
}

//@Composable
//fun BottomAppBar(
//    modifier: Modifier = Modifier,
//    containerColor: Color = BottomAppBarDefaults.containerColor,
//    contentColor: Color = contentColorFor(containerColor),
//    tonalElevation: Dp = BottomAppBarDefaults.ContainerElevation,
//    contentPadding: PaddingValues = BottomAppBarDefaults.ContentPadding,
//    windowInsets: WindowInsets = BottomAppBarDefaults.windowInsets,
//    content: @Composable RowScope.() -> Unit
//): Unit{
//
//}



/*
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
fun BurgerListScreen(viewModel: BurgerListViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.getBurgerList()
    }
    val burgers by viewModel.burgers.observeAsState()
    val bg = listOf("dfd", "gfggf", "sdfsdg", "etyhe", "wetrtwert", "vfdgre")
    LaunchedEffect(Unit) {
        viewModel.getBurgerList()
    }

    LazyColumn {
 //       burgers?.let {
            items(burgers?: emptyList()) {
                BurgerItem(it)
            }
//        }
    }
}

*/



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



