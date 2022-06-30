package com.example.lesson4noteproject.domain

class EditNoteUseCase(private val noteRepository: NoteRepository) {

    fun editNote(note: Note) {
        noteRepository.editNote(note)
    }

}