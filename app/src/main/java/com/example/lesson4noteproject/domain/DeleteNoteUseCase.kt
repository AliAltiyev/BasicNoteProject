package com.example.lesson4noteproject.domain

class DeleteNoteUseCase(private val noteRepository: NoteRepository) {

    fun deleteNote(note: Note) {
        noteRepository.deleteNote(note)
    }
}