package com.example.lesson4noteproject.domain

import androidx.lifecycle.LiveData

interface NoteRepository {

    fun addNote(note: Note)

    fun deleteNote(note: Note)

    fun editNote(note: Note)

    fun getNote(id: Int): Note

    fun getNoteList(): LiveData<List<Note>>

}