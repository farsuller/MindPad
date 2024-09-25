package com.solodev.mindpad.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.solodev.mindpad.feature_note.presentation.screen.note.components.DefaultChipButton
import com.solodev.mindpad.ui.theme.MindPadTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MindPadTheme {
                Surface {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                        var isSelectedTitle by remember { mutableStateOf(true) }
                        var isSelectedDate by remember { mutableStateOf(false) }
                        var isSelectedColor by remember { mutableStateOf(false) }

                        var isAscending by remember { mutableStateOf(true) }
                        var isDescending by remember { mutableStateOf(false) }

                        Column {
                            Row(
                                modifier = Modifier.padding(10.dp),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                DefaultChipButton(text = "Title",
                                    onSelectionChanged = {
                                        isSelectedTitle = true
                                        isSelectedDate = false
                                        isSelectedColor = false
                                    },
                                    isSelected = isSelectedTitle,
                                )
                                DefaultChipButton(text = "Date",
                                    onSelectionChanged = {
                                        isSelectedTitle = false
                                        isSelectedDate = true
                                        isSelectedColor = false
                                    },
                                    isSelected = isSelectedDate,
                                )
                                DefaultChipButton(text = "Color",
                                    onSelectionChanged = {
                                        isSelectedTitle = false
                                        isSelectedDate = false
                                        isSelectedColor = true
                                    },
                                    isSelected = isSelectedColor,
                                    )
                            }
                            Row(
                                modifier = Modifier.padding(10.dp),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                DefaultChipButton(text = "Ascending",
                                    onSelectionChanged = {
                                        isAscending = true
                                        isDescending = false
                                    },
                                    isSelected = isAscending,)
                                DefaultChipButton(text = "Descending",
                                    onSelectionChanged = {
                                        isDescending = true
                                        isAscending = false
                                    },
                                    isSelected = isDescending,)
                            }
                        }

                    }
                }

            }
        }
    }
}



