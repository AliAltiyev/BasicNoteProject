package com.example.lesson4noteproject.domain

import androidx.lifecycle.LiveData

class GetNoteListUseCase(private val noteRepository: NoteRepository) {

    fun getNoteList(): LiveData<List<Note>> {
        return noteRepository.getNoteList()
    }

}