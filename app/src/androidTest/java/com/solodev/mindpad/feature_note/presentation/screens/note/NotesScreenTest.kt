package com.solodev.mindpad.feature_note.presentation.screens.note

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.solodev.mindpad.di.AppModule
import com.solodev.mindpad.feature_note.presentation.MainActivity
import com.solodev.mindpad.feature_note.presentation.routes.Screen
import com.solodev.mindpad.ui.theme.MindPadTheme
import com.solodev.mindpad.utils.Constants.TestTags.ORDER_SECTION_CARD
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@HiltAndroidTest
@UninstallModules(AppModule::class)
class NotesScreenTest() {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
//        composeRule.setContent {
//            val navController = rememberNavController()
//            MindPadTheme {
//                NavHost(
//                    navController = navController,
//                    startDestination = Screen.NotesScreen.route)
//                {
//                    composable(route = Screen.NotesScreen.route) {
//                        NotesScreen(navController = navController)
//                    }
//                }
//            }
//        }
    }


    @Test
    fun clickToggleOrderSection_isVisible() {
        composeRule.onNodeWithTag(ORDER_SECTION_CARD).assertDoesNotExist()
        composeRule.onNodeWithContentDescription("Sort").performClick()
        composeRule.onNodeWithTag(ORDER_SECTION_CARD).assertIsDisplayed()
    }

}