package com.example.animelist.ui

import com.example.animelist.LocalDataProvider
import com.example.animelist.model.AnimeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AnimeViewModel {
    var _uiState = MutableStateFlow(AnimeUiState())

    val uiState: StateFlow<AnimeUiState> = _uiState


}