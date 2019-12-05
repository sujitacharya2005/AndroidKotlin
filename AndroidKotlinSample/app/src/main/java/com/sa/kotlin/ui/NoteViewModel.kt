package com.sa.kotlin.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sa.kotlin.model.Note
import com.sa.kotlin.model.NoteRepository


class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: NoteRepository = NoteRepository(application)
    internal val allNotes: LiveData<List<Note>>
    init {
        allNotes = repository.allNotes
    }

    fun insert(note: Note?) {
        repository.insert(note)
    }

    fun update(note: Note?) {
        repository.update(note)
    }

    fun delete(note: Note?) {
        repository.delete(note)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }
}