package com.example.animelist.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


enum class AnimeListAppScreen{
    HomeScreen,
    GenreScreen,
}

enum class ScreenContentType{
    LIST_ONLY, LIST_AND_DETAILS
}

@Composable
fun AnimeListApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
){
    val navController: NavHostController = rememberNavController()
    val viewModel: AnimeViewModel = viewModel()
    val uiState by viewModel._uiState.collectAsState()
    val screenContentType = when (windowSize){
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> ScreenContentType.LIST_ONLY
        WindowWidthSizeClass.Expanded -> ScreenContentType.LIST_AND_DETAILS
        else -> ScreenContentType.LIST_ONLY
    }


    NavHost(navController = navController, startDestination = AnimeListAppScreen.HomeScreen.name ){
        composable(route = AnimeListAppScreen.HomeScreen.name){
            HomeScreen(
                genres = viewModel.genres,
                onClick = {
                    viewModel.updateCurrentGenre(it)
                    navController.navigate(AnimeListAppScreen.GenreScreen.name)
                },
            )
        }
        composable(route = AnimeListAppScreen.GenreScreen.name){
            GenreScreen(
                uiState = uiState,
                screenContentType = screenContentType,
                onDetailsScreenBackPressed = {
                    viewModel.resetToGenreScreen()
                },
                onBackPressed = {
                    navController.navigateUp()
                },
                onAnimeClick = {
                    viewModel.updateCurrentAnime(it)
                },
            )
        }
    }


}


