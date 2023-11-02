package com.example.animelist.ui

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animelist.R
import com.example.animelist.data.LocalDataProvider
import com.example.animelist.model.AnimeGenreType
import com.example.animelist.ui.theme.AnimeListTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar(){
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        title = {
            Text(text = stringResource(R.string.app_name))
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    genres: List<AnimeGenreType>,
    onClick: (AnimeGenreType) -> Unit,
    modifier: Modifier = Modifier
) {

    Scaffold(
        topBar = {
            HomeScreenTopBar()
        },
        modifier = modifier
    ) {innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 300.dp),
            modifier = Modifier.padding(innerPadding)
        ){
            items(genres){genre ->
                HomeScreenGridItem(
                    genre = genre,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.small)
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .clickable { onClick(genre) }
                )
            }
        }
    }



}

@Composable
fun HomeScreenGridItem(
    genre: AnimeGenreType,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            GridItemImage(imageRes = genre.imageRes)
            Text(
                text = genre.name,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun GridItemImage(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .size(dimensionResource(R.dimen.grid_image_medium_height)),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview("Light theme", showBackground = true)
@Preview("Dark theme", showBackground = true,  uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview(){
    AnimeListTheme {
        HomeScreen(genres = LocalDataProvider.genreList, onClick = { })
    }
}