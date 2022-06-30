package com.example.lesson4noteproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lesson4noteproject.domain.Note
import com.example.lesson4noteproject.domain.NoteRepository
import kotlin.random.Random

object NoteRepositoryImpl : NoteRepository {

    private val noteList =  sortedSetOf<Note>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrementId = 0
    private val listLiveData = MutableLiveData<List<Note>>()

    init {
        for (i in 1..100) {
            val note = Note(i.toString(), i, Random.nextBoolean())
            addNote(note)
        }

    }

    override fun addNote(note: Note) {
        if (note.id == Note.UNDEFINED_ID) {
            note.id = autoIncrementId++
        }

        noteList.add(note)
        update()
    }

    override fun deleteNote(note: Note) {
        noteList.remove(note)
        update()
    }

    override fun editNote(note: Note) {
        val oldNote = getNote(note.id)
        noteList.remove(oldNote)
        addNote(note)

    }

    override fun getNote(id: Int): Note {
        return noteList.find { it.id == id } ?: throw RuntimeException("Not found $id")

    }

    override fun getNoteList(): LiveData<List<Note>> {
        return listLiveData
    }


    private fun update() {
        listLiveData.postValue(noteList.toList())
    }
}