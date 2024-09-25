package com.solodev.mindpad.feature_note.domain.usecase

data class NotesUseCases (
    val getNotes: GetNotesUseCase,
    val deleteNote: DeleteNoteUseCase,
)