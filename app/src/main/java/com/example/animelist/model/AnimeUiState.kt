package com.example.animelist.model

import com.example.animelist.LocalDataProvider

data class AnimeUiState(
    val genreAnime: Map<AnimeGenreType, List<Anime>> = LocalDataProvider.animeList.groupBy { it.genre },
    val currentAnime: Anime? = null,
    val currentGenre: AnimeGenreType? = null,
    val isShowingHomepage : Boolean= true,
){
    val currentGenreAnime:List<Anime> by lazy { genreAnime[currentGenre] ?: emptyList() }
}
