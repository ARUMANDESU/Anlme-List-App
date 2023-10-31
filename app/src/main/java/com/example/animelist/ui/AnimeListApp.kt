package com.example.animelist.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


enum class AnimeListAppScreen{
    HomeScreen,
    GenreScreen,
}



@Composable
fun AnimeListApp(){
    val navController: NavHostController = rememberNavController()
    val viewModel: AnimeViewModel = viewModel()
    val uiState by viewModel._uiState.collectAsState()


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


