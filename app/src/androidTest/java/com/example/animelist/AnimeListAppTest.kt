package com.example.animelist

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.animelist.data.LocalDataProvider
import com.example.animelist.ui.AnimeListApp
import org.junit.Rule
import org.junit.Test


class AnimeListAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun compactDevice_verifyUsingTopBar(){
        composeTestRule.setContent {
            AnimeListApp(windowSize = WindowWidthSizeClass.Compact)
        }

        composeTestRule.onNodeWithTagForStringId(R.string.home_top_bar)
            .assertExists()

        composeTestRule.onNodeWithText(LocalDataProvider.genreList[0].name)
            .assertIsDisplayed()

        composeTestRule.onNodeWithText(LocalDataProvider.genreList[0].name)
            .performClick()

        composeTestRule.onNodeWithTagForStringId(R.string.genre_top_bar)
            .assertExists()


        composeTestRule.onNodeWithText(LocalDataProvider.animeList[0].title)
            .assertIsDisplayed()

        composeTestRule.onNodeWithText(LocalDataProvider.animeList[0].title)
            .performClick()

        composeTestRule.onNodeWithTagForStringId(R.string.details_top_bar)
            .assertExists()


    }

    @Test
    fun mediumDevice_verifyUsingTopBar(){
        composeTestRule.setContent {
            AnimeListApp(windowSize = WindowWidthSizeClass.Medium)
        }

        composeTestRule.onNodeWithTagForStringId(R.string.home_top_bar)
            .assertExists()

        composeTestRule.onNodeWithText(LocalDataProvider.genreList[0].name)
            .assertIsDisplayed()

        composeTestRule.onNodeWithText(LocalDataProvider.genreList[0].name)
            .performClick()

        composeTestRule.onNodeWithTagForStringId(R.string.genre_top_bar)
            .assertExists()


        composeTestRule.onNodeWithText(LocalDataProvider.animeList[0].title)
            .assertIsDisplayed()

        composeTestRule.onNodeWithText(LocalDataProvider.animeList[0].title)
            .performClick()

        composeTestRule.onNodeWithTagForStringId(R.string.details_top_bar)
            .assertExists()

    }

    @Test
    fun expandedDevice_verifyUsingTopBar(){
        composeTestRule.setContent {
            AnimeListApp(windowSize = WindowWidthSizeClass.Expanded)
        }

        composeTestRule.onNodeWithTagForStringId(R.string.home_top_bar)
            .assertExists()

        composeTestRule.onNodeWithText(LocalDataProvider.genreList[0].name)
            .assertIsDisplayed()

        composeTestRule.onNodeWithText(LocalDataProvider.genreList[0].name)
            .performClick()

        composeTestRule.onNodeWithTagForStringId(R.string.genre_top_bar)
            .assertExists()


        composeTestRule.onNodeWithText(LocalDataProvider.animeList[0].title)
            .assertIsDisplayed()

        composeTestRule.onNodeWithText(LocalDataProvider.animeList[0].title)
            .performClick()

        composeTestRule.onNodeWithTagForStringId(R.string.details_top_bar)
            .assertDoesNotExist() // should not exists

    }

}