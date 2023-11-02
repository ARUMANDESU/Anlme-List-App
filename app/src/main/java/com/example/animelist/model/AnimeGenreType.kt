package com.example.animelist.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.animelist.R
// Or should I use data class
enum class AnimeGenreType(
    @DrawableRes val imageRes: Int,
    @StringRes val infoRes: Int
) {
    Kodomomuke(
        R.drawable.kodomomuke,
        R.string.kodomomuke_info
    ),
    Shonen(
        R.drawable.shonen,
        R.string.shonen_info
    ),
    Shojo(
        R.drawable.shojo,
        R.string.shojo_info
    ),
    Seinen(
        R.drawable.seinen,
        R.string.seinen_info
    ),
    Josei(
        R.drawable.josei,
        R.string.josei_info
    )
}