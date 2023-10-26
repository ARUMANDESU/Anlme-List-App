package com.example.animelist.model

import androidx.annotation.DrawableRes
import com.example.animelist.R

enum class AnimeGenreType(@DrawableRes val imageRes: Int) {
    Kodomomuke(R.drawable.kodomomuke),
    Shonen(R.drawable.shonen),
    Shojo(R.drawable.shojo),
    Seinen(R.drawable.seinen),
    Josei(R.drawable.josei)
}