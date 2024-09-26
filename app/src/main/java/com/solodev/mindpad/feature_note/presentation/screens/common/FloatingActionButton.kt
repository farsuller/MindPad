package com.solodev.mindpad.feature_note.presentation.screens.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun MindPadFAB(onClick: () -> Unit,
                         color: Color = MaterialTheme.colorScheme.tertiary,
                         imageVector: ImageVector = Icons.Filled.Save) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = color
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = "Save note"
        )
    }
}