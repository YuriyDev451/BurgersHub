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
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CardColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.gukunov.burgershub.R
import com.gukunov.burgershub.domain.entity.BurgerItem
import com.gukunov.burgershub.domain.uiModel.BurgerItemUIModel
import com.gukunov.burgershub.presentation.navigation.AppNavigation
import com.gukunov.burgershub.presentation.screens.MainS
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                MainS()
            }


        }
    }

}












//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BurgerListScreen(viewModel: BurgerListViewModel = hiltViewModel()) {
//    val burgerList by viewModel.burgers.collectAsState(initial = emptyList())
////    BurgerList(burgers = burgerList)
//    BurgerList(burgers = burgerList)
////    , modifier = Modifier.padding()
//
////    Scaffold(
////        topBar = {
////            CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(
////                containerColor = MaterialTheme.colorScheme.primaryContainer,
////                titleContentColor = MaterialTheme.colorScheme.primary),
////                modifier = Modifier.clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)),
////                title = {
////                    Text(
////                        text = "BurgersHub",
////                        fontSize = 24.sp,
////                        color = MaterialTheme.colorScheme.primary)
////
////                })
////        },
//////        bottomBar = {
////////            BottomAppBar(
////////                modifier = Modifier,
////////                actions = {
////////                    Row(modifier = Modifier.fillMaxWidth(),
////////                        horizontalArrangement = Arrangement.SpaceEvenly,
////////                        verticalAlignment = Alignment.CenterVertically) {
////////                        IconButton(onClick = { /* do something */ }) {
////////                            Icon(Icons.Filled.Home, contentDescription = "Localized description")
////////                        }
////////                        IconButton(onClick = { /* do something */ }) {
////////                            Icon(
////////                                Icons.Filled.Favorite,
////////                                contentDescription = "Localized description",
////////                            )
////////                        }
////////                        IconButton(onClick = { /* do something */ }) {
////////                            Icon(
////////                                Icons.Filled.Settings,
////////                                contentDescription = "Localized description",
////////                            )
////////                        }
////////                        IconButton(onClick = { /* do something */ }) {
////////                            Icon(
////////                                Icons.Filled.Share,
////////                                contentDescription = "Localized description",
////////                            )
////////                        }
////////                    }
////////
////////                })
//////        },
////        content = {
////            BurgerList(burgers = burgerList, modifier = Modifier.padding(it))
////        }
////    )
//
//
//}

@Composable
fun BurgerList(burgers: List<BurgerItem>?, modifier: Modifier = Modifier) {
    val burgersState = remember { burgers?.let { mutableStateListOf(*it.toTypedArray()) } }
    burgers?.let {

        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(burgers) { burger ->
                BurgerItemView(burger
//                    ,onToggleFavorite = { updatedBurger ->
//                    val index = burgersState?.indexOfFirst { it.id == updatedBurger.id }
//                    if (index != -1) {
//                        index?.let { it1 ->
//                            burgersState?.set(
//                                it1,
//                                updatedBurger.copy(isFavorite = !updatedBurger.isFavorite)
//                            )
//                        }
//                    }
//                }
                )
            }
        }
    }
}

@Composable
fun BurgerItemView(burger: BurgerItem ) {

    //onToggleFavorite: (BurgerItem) -> Unit
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 10.dp, top = 10.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE4FBFD))
    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

    ) {
        Image(
            painter = rememberAsyncImagePainter(burger.images.firstOrNull()?.sm),
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
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
                    .weight(1f)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
//        Image(imageVector = Icons.Default.Favorite,
//            contentDescription = "Favorite",
//            modifier = Modifier
//                .align(Alignment.CenterVertically)
//                .padding(end = 10.dp)
//                .size(24.dp)
//
//        )
        //FavoriteButton(isFavorite = burger.isFavorite, onToggleFavorite = { onToggleFavorite(burger) })
    }
}
}

//@Composable
//fun FavoriteScreen(
//    favoriteViewModel: FavoriteState = hiltViewModel()
//) {
//    FavoriteButton(
//        isFavorite = favoriteViewModel.isFavorite,
//        onToggleFavorite = { favoriteViewModel.toggleFavorite() }
//    )
//}

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = Color(0xff000000)
) {

//    var isFavorite by remember { mutableStateOf(false) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
//            isFavorite = !isFavorite
            onToggleFavorite()
        }
    ) {
        Icon(
            tint = color,
            modifier = modifier.graphicsLayer {
                scaleX = 1.3f
                scaleY = 1.3f
            },
            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null
        )
    }

}

