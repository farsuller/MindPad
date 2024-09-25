package com.solodev.mindpad.feature_note.presentation.screen.note

import com.solodev.mindpad.feature_note.domain.model.Note
import com.solodev.mindpad.feature_note.domain.util.NoteOrder
import com.solodev.mindpad.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)