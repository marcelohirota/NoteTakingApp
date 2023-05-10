package com.mh.notetakingapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mh.notetakingapp.repository.NoteRepository

class NoteViewModelFactory (
    val application: Application,
    private val noteRepository: NoteRepository) :
    ViewModelProvider.Factory{

            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return NoteViewModel(application, noteRepository) as T
            }
}