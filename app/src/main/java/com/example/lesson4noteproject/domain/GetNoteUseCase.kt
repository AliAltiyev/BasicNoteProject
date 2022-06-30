package com.example.lesson4noteproject.domain

class GetNoteUseCase(private val noteRepository: NoteRepository) {

    fun getNote(id: Int): Note {
       return noteRepository.getNote(id)
    }
}