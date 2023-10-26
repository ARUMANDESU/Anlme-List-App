package com.example.animelist.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Anime(
    val id: Long,
    val title: String,
    val seasons: Int,
    val episodes : Int,
    val genre: AnimeGenreType,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
)
