package com.example.lesson4noteproject.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lesson4noteproject.domain.Note

class NoteListDiffCallback(val oldList: List<Note>, val newList: List<Note>) :
    DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val newItem = newList[newItemPosition]
        val oldItem = oldList[oldItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val newItem = newList[newItemPosition]
        val oldItem = oldList[oldItemPosition]
        return oldItem == newItem   }
}