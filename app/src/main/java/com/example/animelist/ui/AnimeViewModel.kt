package com.example.animelist.ui

import androidx.lifecycle.ViewModel
import com.example.animelist.data.LocalDataProvider
import com.example.animelist.model.Anime
import com.example.animelist.model.AnimeGenreType
import com.example.animelist.model.AnimeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AnimeViewModel: ViewModel() {
    var _uiState = MutableStateFlow(AnimeUiState())

    val uiState: StateFlow<AnimeUiState> = _uiState

    val genres = LocalDataProvider.genreList


    fun updateCurrentGenre(genre: AnimeGenreType){
        _uiState.update {
            it.copy(
                currentGenre = genre,
                currentAnime = it.genreAnime[genre]?.get(0) ?: it.currentAnime
            )
        }
    }

    fun updateCurrentAnime(anime: Anime){
        _uiState.update {
            it.copy(
                currentAnime = anime,
                isShowingGenrePage = false
            )
        }
    }

    fun resetToGenreScreen(){
        _uiState.update {
            it.copy(isShowingGenrePage = true)
        }
    }

}