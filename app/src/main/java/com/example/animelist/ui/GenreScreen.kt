package com.example.animelist.ui

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.animelist.R
import com.example.animelist.data.LocalDataProvider
import com.example.animelist.model.Anime
import com.example.animelist.model.AnimeUiState
import com.example.animelist.ui.theme.AnimeListTheme

@Composable
fun GenreScreen(
    uiState: AnimeUiState,
    onAnimeClick: (Anime) -> Unit,
    modifier: Modifier = Modifier
){
    if (uiState.isShowingGenrePage){
        GenreList(
            currentAnimeList = uiState.currentGenreAnime,
            onClick = onAnimeClick,
            modifier = modifier
        )
    }else{
        AnimeDetails(
            currentAnime = uiState.currentAnime,
            modifier = modifier
        )
    }
}



@Composable
fun GenreList(
    currentAnimeList: List<Anime>,
    onClick: (Anime) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier
    ){
        items(currentAnimeList){ anime ->
            GenreListItem(
                anime = anime,
                modifier = modifier.clickable { onClick(anime) }
            )
        }
    }
}

@Composable
fun GenreListItem(
    anime: Anime,
    modifier: Modifier = Modifier
){
    Card (
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small)),
            verticalAlignment = Alignment.CenterVertically
        ){
            GenreListItemImage(imageRes = anime.image)
            Text(
                text = anime.title,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
            )
        }
    }

}

@Composable
fun GenreListItemImage(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier
){
    Box (
        modifier = modifier.size(dimensionResource(R.dimen.list_image_medium))
    ){
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun AnimeDetails(
    currentAnime: Anime,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Image(painter = painterResource(currentAnime.image), contentDescription = null)
        Column(modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_big))) {
            Text(
                text = stringResource(R.string.seasons, currentAnime.seasons),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = stringResource(R.string.episodes,currentAnime.episodes),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                fontStyle = FontStyle.Italic
            )
        }
        Text(
            text = stringResource(currentAnime.description),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyLarge
        )
    }

}



@Composable
fun GenreListAndAnimeDetails(
    modifier: Modifier = Modifier
){

}

@Preview("Light theme")
@Preview("Dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GenreListItemPreview(){
    AnimeListTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            GenreListItem(anime = LocalDataProvider.defaultAnime)
        }
    }

}

@Preview("Light theme")
@Preview("Dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AnimeDetailsPreview(){

    AnimeListTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AnimeDetails(
                currentAnime = LocalDataProvider.defaultAnime,
                modifier = Modifier.padding(
                    dimensionResource(R.dimen.padding_medium)
                )
            )
        }

    }

}