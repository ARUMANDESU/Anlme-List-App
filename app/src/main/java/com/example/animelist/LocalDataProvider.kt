package com.example.animelist

import com.example.animelist.model.Anime
import com.example.animelist.model.AnimeGenreType

object LocalDataProvider {
    val animeList = listOf(
        Anime(
            id = 1,
            title = "Pokemon series",
            seasons =  26,
            episodes = 1259,
            genre = AnimeGenreType.Kodomomuke,
            description = R.string.pokemon_description,
            image = R.drawable.pokemon_image
        ),
        Anime(
            id = 2,
            title = "Doraemon",
            seasons = 15,
            episodes = 1787,
            genre = AnimeGenreType.Kodomomuke,
            description = R.string.doraemon_description,
            image = R.drawable.doraemon_image
        ),
        Anime(
            id = 3,
            title = "Digimon Adventures",
            seasons = 10,
            episodes = 519,
            genre = AnimeGenreType.Kodomomuke,
            description = R.string.digimon_description,
            image = R.drawable.digimon_image
        ),
        Anime(
            id = 4,
            title = "Beyblade series",
            seasons = 11,
            episodes = 744,
            genre = AnimeGenreType.Kodomomuke,
            description = R.string.beyblade_description,
            image = R.drawable.beyblade_image
        ),
        Anime(
            id = 5,
            title = "Yo-Kai Watch",
            seasons = 3,
            episodes = 214,
            genre = AnimeGenreType.Kodomomuke,
            description = R.string.yokai_watch_description,
            image = R.drawable.yokai_watch_image
        ),
        Anime(
            id = 6,
            title = "Naruto",
            seasons =  2,
            episodes = 720,
            genre = AnimeGenreType.Shonen,
            description = R.string.naruto_description,
            image = R.drawable.naruto_image
        ),
        Anime(
            id = 7,
            title = "One Piece",
            seasons = 1,
            episodes = 1075,
            genre = AnimeGenreType.Shonen,
            description = R.string.one_piece_description,
            image = R.drawable.one_piece_image
        ),
        Anime(
            id = 8,
            title = "Bleach",
            seasons = 17,
            episodes = 392,
            genre = AnimeGenreType.Shonen,
            description = R.string.bleach_description,
            image = R.drawable.bleach_image
        ),
        Anime(
            id = 9,
            title = "Dragon Ball",
            seasons = 9,
            episodes = 153,
            genre = AnimeGenreType.Shonen,
            description = R.string.dragon_ball_description,
            image = R.drawable.dragon_ball_image
        ),
        Anime(
            id = 10,
            title = "Hunter x Hunter (2011)",
            seasons = 1,
            episodes = 148,
            genre = AnimeGenreType.Shonen,
            description = R.string.hunter_x_hunter_description,
            image = R.drawable.hunter_x_hunter_image
        ),
        Anime(
            id = 11,
            title = "Fruits Basket (2019)",
            seasons = 3,
            episodes = 63,
            genre = AnimeGenreType.Shojo,
            description = R.string.fruits_basket_description,
            image = R.drawable.fruits_basket_image
        ),
        Anime(
            id = 12,
            title = "Sailor Moon",
            seasons = 5,
            episodes = 200,
            genre = AnimeGenreType.Shojo,
            description = R.string.sailor_moon_description,
            image = R.drawable.sailor_moon_image
        ),
        Anime(
            id = 13,
            title = "Violet Evergarden",
            seasons = 1,
            episodes = 13,
            genre = AnimeGenreType.Shojo,
            description = R.string.violet_evergarden_description,
            image = R.drawable.violet_evergarden_image
        ),
        Anime(
            id = 14,
            title = "Banana Fish",
            seasons = 1,
            episodes = 24,
            genre = AnimeGenreType.Shojo,
            description = R.string.banana_fish_description,
            image = R.drawable.banana_fish_image
        ),
        Anime(
            id = 15,
            title = "Kaichou wa Maid-sama!",
            seasons = 1,
            episodes = 26,
            genre = AnimeGenreType.Shojo,
            description = R.string.kaichou_wa_maid_sama_description,
            image = R.drawable.kaichou_wa_maid_sama_image
        ),
        Anime(
            id = 16,
            title = "Berserk",
            seasons = 0,
            episodes = 0,
            genre = AnimeGenreType.Seinen,
            description = R.string.berserk_description,
            image = R.drawable.berserk_image
        ),
        Anime(
            id = 17,
            title = "Vagabond",
            seasons = 0,
            episodes = 0,
            genre = AnimeGenreType.Seinen,
            description = R.string.vagabond_description,
            image = R.drawable.vagabond_image
        ),
        Anime(
            id = 18,
            title = "Vinland Saga",
            seasons = 2,
            episodes = 48,
            genre = AnimeGenreType.Seinen,
            description = R.string.vinland_saga_description,
            image = R.drawable.vinland_saga_image
        ),
        Anime(
            id = 19,
            title = "Monster",
            seasons = 1,
            episodes = 74,
            genre = AnimeGenreType.Seinen,
            description = R.string.monster_description,
            image = R.drawable.monster_image
        ),
        Anime(
            id = 20,
            title = "Kaguya-sama: Love is War – Ultra Romantic",
            seasons = 3,
            episodes = 37,
            genre = AnimeGenreType.Seinen,
            description = R.string.kaguya_sama_description,
            image = R.drawable.kaguya_sama_image
        ),
        Anime(
            id = 21,
            title = "Descending Stories: Showa Genroku Rakugo Shinju",
            seasons = 2,
            episodes = 25,
            genre = AnimeGenreType.Josei,
            description = R.string.rakugo_shinju_description,
            image = R.drawable.rakugo_shinju_image
        ),
        Anime(
            id = 22,
            title = "Usagi Drop",
            seasons = 1,
            episodes = 11,
            genre = AnimeGenreType.Josei,
            description = R.string.usagi_drop_description,
            image = R.drawable.usagi_drop_image
        ),
        Anime(
            id = 23,
            title = "Princess Jellyfish",
            seasons = 1,
            episodes = 1,
            genre = AnimeGenreType.Josei,
            description = R.string.princess_jellyfish_description,
            image = R.drawable.princess_jellyfish_image
        ),
        Anime(
            id = 24,
            title = "Chihayafuru Series",
            seasons = 3,
            episodes = 74,
            genre = AnimeGenreType.Josei,
            description = R.string.chihayafuru_description,
            image = R.drawable.chihayafuru_image
        ),
        Anime(
            id = 25,
            title = "Kids on the Slope",
            seasons = 1,
            episodes = 12,
            genre = AnimeGenreType.Josei,
            description = R.string.kids_on_the_slope_description,
            image = R.drawable.kids_on_the_slope_image
        ),
    )
}