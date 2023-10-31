package com.example.animelist.model

import com.example.animelist.data.LocalDataProvider

data class AnimeUiState(
    val genreAnime: Map<AnimeGenreType, List<Anime>> = LocalDataProvider.animeList.groupBy { it.genre },
    val currentAnime: Anime = LocalDataProvider.defaultAnime,
    val currentGenre: AnimeGenreType = LocalDataProvider.defaultGenre,
    val isShowingGenrePage : Boolean= true,
){
    val currentGenreAnime:List<Anime> by lazy { genreAnime[currentGenre] ?: emptyList() }
}
