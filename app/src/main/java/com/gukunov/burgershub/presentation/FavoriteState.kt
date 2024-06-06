package com.gukunov.burgershub.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.gukunov.burgershub.domain.entity.BurgerItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

//@HiltViewModel
//class FavoriteState @Inject constructor(): ViewModel() {
////    private val _favoriteBurgers = MutableStateFlow<List<BurgerItem>>(emptyList())
////    val favoriteBurgers: StateFlow<List<BurgerItem>> = _favoriteBurgers
////
////    fun toggleFavorite(burger: BurgerItem) {
////        val currentFavorites = _favoriteBurgers.value.toMutableList()
////        if (burger.isFavorite) {
////            currentFavorites.remove(burger)
////        } else {
////            currentFavorites.add(burger)
////        }
////        _favoriteBurgers.value = currentFavorites
////    }
//}