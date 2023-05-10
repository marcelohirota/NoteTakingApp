package com.mh.notetakingapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mh.notetakingapp.model.Note
import com.mh.notetakingapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(
    application: Application,
    private val noteRepository: NoteRepository) :
    AndroidViewModel(application){

        fun addNote(note: Note) = viewModelScope.launch {
            noteRepository.insertNote(note)
        }

        fun deleteNote (note: Note) = viewModelScope.launch {
            noteRepository.deleteNote (note)
        }

        fun updateNote (note: Note) = viewModelScope.launch {
            noteRepository.updateNote (note)
        }

        fun searchNotes (query: String?) = noteRepository.searchNotes (query)

        fun getAllNotes () = noteRepository.getAllNotes ()
}