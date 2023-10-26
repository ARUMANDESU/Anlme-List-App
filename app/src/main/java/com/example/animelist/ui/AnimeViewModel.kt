package com.example.animelist.ui

import com.example.animelist.model.Anime
import com.example.animelist.model.AnimeGenreType
import com.example.animelist.model.AnimeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AnimeViewModel {
    var _uiState = MutableStateFlow(AnimeUiState())

    val uiState: StateFlow<AnimeUiState> = _uiState



    fun updateCurrentGenre(genre: AnimeGenreType){
        _uiState.update {
            it.copy(currentGenre = genre)
        }
    }

    fun updateCurrentAnime(anime: Anime){
        _uiState.update {
            it.copy(currentAnime = anime)
        }
    }


}