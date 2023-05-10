package com.mh.notetakingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.mh.notetakingapp.MainActivity
import com.mh.notetakingapp.R
import com.mh.notetakingapp.adapter.NoteAdapter
import com.mh.notetakingapp.databinding.FragmentNewNoteBinding
import com.mh.notetakingapp.model.Note
import com.mh.notetakingapp.viewmodel.NoteViewModel


class NewNoteFragment : Fragment(R.layout.fragment_new_note) {


    private lateinit var notesViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var mView: View

    private var _binding: FragmentNewNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel = (activity as MainActivity).noteViewModel
        mView = view

    }

    private fun savenote(view: View) {
        val noteTitle = binding.etNoteTitle.text.toString().trim()
        val noteBody = binding.etNoteBody.text.toString().trim()

        if (noteTitle.isNotEmpty()) {
            val note = Note(
                0, noteTitle, noteBody
            )
            notesViewModel.addNote(note)

            Toast.makeText(mView.context, "Note Saved", Toast.LENGTH_LONG).show()

            view.findNavController().navigate(
                R.id.action_newNoteFragment_to_homeFragment
            )
        } else {
            Toast.makeText(mView.context, "Please enter a title", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_new_note, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuSave -> {
                savenote(mView)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}