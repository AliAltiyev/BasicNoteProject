package com.example.lesson4noteproject.domain

class AddNoteUseCase(private val noteRepository: NoteRepository) {

    fun addNote(note: Note) {
        noteRepository.addNote(note)
    }
}