package com.solodev.mindpad.feature_note.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.solodev.mindpad.feature_note.data.repository.FakeNoteRepository
import com.solodev.mindpad.feature_note.domain.model.InvalidNoteException
import com.solodev.mindpad.feature_note.domain.model.Note
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertThrows
import org.junit.Before

import org.junit.Test

class AddNoteTest {

    private lateinit var addNote: AddNote
    private lateinit var fakeNoteRepository: FakeNoteRepository

    @Before
    fun setUp(){
        fakeNoteRepository = FakeNoteRepository()
        addNote = AddNote(fakeNoteRepository)

    }

    @Test
    fun `Add valid note, note is added`() = runBlocking {
        val note = Note(
            title = "Test Note",
            content = "This is a test note",
            timestamp = System.currentTimeMillis(),
            color = 1
        )

        addNote.invoke(note)

        val allNotes = fakeNoteRepository.getNotes().first()
        assertThat(allNotes).contains(note)
    }

    @Test
    fun `Add note with empty title, throws InvalidNoteException`() = runBlocking {
        val note = Note(
            title = "",
            content = "This is a test note",
            timestamp = System.currentTimeMillis(),
            color = 1
        )

        val exception = assertThrows(InvalidNoteException::class.java) {
            runBlocking { addNote.invoke(note) }
        }

        assertThat(exception).hasMessageThat().isEqualTo("The title of the note can't be empty")
    }

    @Test
    fun `Add note with empty content, throws InvalidNoteException`() = runBlocking {
        val note = Note(
            title = "Test Note",
            content = "",
            timestamp = System.currentTimeMillis(),
            color = 1
        )

        val exception = assertThrows(InvalidNoteException::class.java) {
            runBlocking { addNote.invoke(note) }
        }

        assertThat(exception).hasMessageThat().isEqualTo("The content of the note can't be empty")
    }

    @Test
    fun `Add note with valid title and content, repository is updated`() = runBlocking {
        val note = Note(
            title = "Valid Title",
            content = "Valid Content",
            timestamp = System.currentTimeMillis(),
            color = 2
        )

        addNote.invoke(note)

        val allNotes = fakeNoteRepository.getNotes().first()
        assertThat(allNotes.size).isEqualTo(1)
        assertThat(allNotes[0].title).isEqualTo("Valid Title")
        assertThat(allNotes[0].content).isEqualTo("Valid Content")
    }

}