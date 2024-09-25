package com.solodev.mindpad.feature_note.domain.usecase

data class NotesUseCases (
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote,
)