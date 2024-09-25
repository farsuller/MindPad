package com.solodev.mindpad.di

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Room
import androidx.room.RoomDatabase
import com.solodev.mindpad.feature_note.data.local.NoteDatabase
import com.solodev.mindpad.feature_note.data.repository.NoteRepositoryImpl
import com.solodev.mindpad.feature_note.domain.repository.NoteRepository
import com.solodev.mindpad.feature_note.domain.usecase.DeleteNoteUseCase
import com.solodev.mindpad.feature_note.domain.usecase.GetNotesUseCase
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
            getNotes = GetNotesUseCase(repository = repository),
            deleteNote = DeleteNoteUseCase(repository = repository)
        )
    }
}