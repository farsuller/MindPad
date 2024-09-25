package com.solodev.mindpad.feature_note.presentation.screen.note.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.solodev.mindpad.feature_note.domain.model.Note

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    note : Note,
    cornerRadius : Dp = 10.dp,
    cutCornerSize : Dp = 30.dp,
    onDeleteClick : () -> Unit
){

}