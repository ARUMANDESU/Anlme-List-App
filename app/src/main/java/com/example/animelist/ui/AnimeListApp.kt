package com.example.animelist.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animelist.R


enum class AnimeListAppScreen{
    HomeScreen,
    GenreScreen,
    AnimeDetailsScreen
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
                onDetailsScreenBackPresed = {
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


