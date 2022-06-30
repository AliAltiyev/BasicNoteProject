package com.example.lesson4noteproject.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson4noteproject.R

class NoteViewHolder( val view: View) : RecyclerView.ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.noteName)
    val tvCount = view.findViewById<TextView>(R.id.count)

}
