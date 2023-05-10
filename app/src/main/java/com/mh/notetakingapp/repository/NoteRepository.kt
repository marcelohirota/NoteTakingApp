package com.mh.notetakingapp.repository

import com.mh.notetakingapp.database.NoteDatabase
import com.mh.notetakingapp.model.Note

class NoteRepository(private val db: NoteDatabase) {

        suspend fun insert(note: Note) = db.getNoteDao().insertNote(note)

        suspend fun delete(note: Note) = db.getNoteDao().deleteNote(note)

        fun getAllNotes() = db.getNoteDao().getAllNotes()
}