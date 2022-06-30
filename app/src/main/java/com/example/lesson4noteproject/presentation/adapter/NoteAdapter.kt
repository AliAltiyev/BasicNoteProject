package com.example.lesson4noteproject.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.lesson4noteproject.R
import com.example.lesson4noteproject.domain.Note


class NoteAdapter : ListAdapter<Note, NoteViewHolder>(NoteItemDiffCalBack()) {

    var longClick: ((Note) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val layout = when (viewType) {
            ENABLED_ITEM -> R.layout.item_recycler_view
            DISABLED_ITEM -> R.layout.item_recycler_view_disabled
            else -> throw RuntimeException("Invalid view type")

        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = getItem(position)
        holder.tvName.text = item.name
        holder.tvCount.text = item.count.toString()
        holder.view.setOnLongClickListener {
            longClick?.invoke(item)
            true
        }

    }


    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) {
            ENABLED_ITEM
        } else {
            DISABLED_ITEM
        }

    }


    companion object {
        const val ENABLED_ITEM = 101
        const val DISABLED_ITEM = 102
        const val MAX_POOL_SIZE = 20
    }
}
