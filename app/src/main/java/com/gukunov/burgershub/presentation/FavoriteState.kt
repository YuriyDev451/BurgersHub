package com.gukunov.burgershub.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteState@Inject constructor(): ViewModel() {
    var isFavorite by mutableStateOf(false)
    private set


    fun toggleFavorite() {
        isFavorite = !isFavorite
    }
}