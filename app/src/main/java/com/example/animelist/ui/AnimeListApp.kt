package com.example.animelist.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
    HomeScreen, GenreScreen
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeListApp(){
    val navController: NavHostController = rememberNavController()
    val viewModel: AnimeViewModel = viewModel()
    val uiState by viewModel._uiState.collectAsState()

    Scaffold(
        topBar = {
            AppTopBar()
        }
    ) {innerPadding ->
        NavHost(navController = navController, startDestination = AnimeListAppScreen.HomeScreen.name ){
            composable(route = AnimeListAppScreen.HomeScreen.name){
                HomeScreen(
                    genres = viewModel.genres,
                    onClick = {
                        viewModel.updateCurrentGenre(it)
                        navController.navigate(AnimeListAppScreen.GenreScreen.name)
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            }
            composable(route = AnimeListAppScreen.GenreScreen.name){
                GenreScreen(
                    uiState = uiState,
                    onDetailsScreenBackPresed = {
                        viewModel.resetToGenreScreen()
                    },
                    onAnimeClick = {
                        viewModel.updateCurrentAnime(it)
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }

    }
}

@Composable
fun AppTopBar(){

}