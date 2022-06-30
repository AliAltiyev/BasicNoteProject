package com.example.lesson4noteproject.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lesson4noteproject.domain.Note

class NoteItemDiffCalBack : DiffUtil.ItemCallback<Note>() {


    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem

    }
}