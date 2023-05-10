package com.mh.notetakingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mh.notetakingapp.database.NoteDatabase
import com.mh.notetakingapp.databinding.ActivityMainBinding
import com.mh.notetakingapp.repository.NoteRepository
import com.mh.notetakingapp.viewmodel.NoteViewModel
import com.mh.notetakingapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))

        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)

        noteViewModel =
            ViewModelProvider(this, viewModelProviderFactory).get(NoteViewModel::class.java)
    }
}