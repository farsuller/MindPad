package com.solodev.mindpad.di

import android.app.Application
import androidx.room.Room
import com.solodev.mindpad.feature_note.data.local.NoteDatabase
import com.solodev.mindpad.feature_note.data.repository.NoteRepositoryImpl
import com.solodev.mindpad.feature_note.domain.repository.NoteRepository
import com.solodev.mindpad.feature_note.domain.usecase.AddNote
import com.solodev.mindpad.feature_note.domain.usecase.DeleteNote
import com.solodev.mindpad.feature_note.domain.usecase.GetNote
import com.solodev.mindpad.feature_note.domain.usecase.GetNotes
import com.solodev.mindpad.feature_note.domain.usecase.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(application: Application): NoteDatabase {
        return Room.databaseBuilder(
            application,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db : NoteDatabase) : NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NotesUseCases {
        return NotesUseCases(
            getNotes = GetNotes(repository = repository),
            deleteNote = DeleteNote(repository = repository),
            addNote =  AddNote(repository = repository),
            getNote = GetNote(repository = repository)
        )
    }
}