package com.mh.notetakingapp.repository

import com.mh.notetakingapp.database.NoteDatabase
import com.mh.notetakingapp.model.Note

class NoteRepository(private val db: NoteDatabase) {

        suspend fun insertNote(note: Note) = db.getNoteDao().insertNote(note)

        suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

        suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

        fun searchNotes(query: String?) = db.getNoteDao().searchNote(query)

        fun getAllNotes() = db.getNoteDao().getAllNotes()
}