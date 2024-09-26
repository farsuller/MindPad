package com.solodev.mindpad.feature_note.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.solodev.mindpad.ui.theme.*

@Entity
data class Note(
    val title: String,
    val content : String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id : Int? = null
){
    companion object {
        val noteColors = listOf(
            Color(0xFFDAE2F9),
            Color(0xFF92AFE3),
            Color(0xFFFFB4AB),
            Color(0xFFFAD8FD),
            Color(0xFFFFDAD6))
    }
}


class InvalidNoteException(message: String): Exception(message)
