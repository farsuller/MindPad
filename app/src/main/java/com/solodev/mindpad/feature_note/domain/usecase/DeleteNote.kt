package com.solodev.mindpad.feature_note.domain.usecase

import com.solodev.mindpad.feature_note.domain.model.Note
import com.solodev.mindpad.feature_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}