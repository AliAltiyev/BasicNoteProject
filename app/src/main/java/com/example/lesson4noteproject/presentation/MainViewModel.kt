package com.example.lesson4noteproject.presentation

import androidx.lifecycle.ViewModel
import com.example.lesson4noteproject.data.NoteRepositoryImpl
import com.example.lesson4noteproject.domain.*

class MainViewModel : ViewModel() {

    private val repository = NoteRepositoryImpl

    private val deleteNoteUseCase = DeleteNoteUseCase(repository)
    private val editNoteUseCase = EditNoteUseCase(repository)
    private val getNoteListUseCase = GetNoteListUseCase(repository)
    val getListNoteLiveDate = getNoteListUseCase.getNoteList()


    fun deleteNote(note: Note) {
        deleteNoteUseCase.deleteNote(note)

    }


    fun editNote(note: Note) {
        val newNote = note.copy(enabled = !note.enabled)
        editNoteUseCase.editNote(newNote)

    }

}