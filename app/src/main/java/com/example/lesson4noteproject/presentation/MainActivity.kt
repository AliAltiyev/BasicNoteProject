package com.example.lesson4noteproject.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson4noteproject.databinding.ActivityMainBinding
import com.example.lesson4noteproject.presentation.adapter.NoteAdapter
import com.example.lesson4noteproject.presentation.adapter.NoteAdapter.Companion.MAX_POOL_SIZE

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initAdapter()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getListNoteLiveDate.observe(this) {
            adapter.submitList(it)
        }
        longClick()
        onSwiped()
    }


    private fun initAdapter() {
        adapter = NoteAdapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.recycledViewPool.setMaxRecycledViews(NoteAdapter.DISABLED_ITEM,
            MAX_POOL_SIZE)
        binding.recyclerview.recycledViewPool.setMaxRecycledViews(NoteAdapter.ENABLED_ITEM,
            MAX_POOL_SIZE)

    }

    private fun longClick() {
        adapter.longClick = {
            viewModel.editNote(it)
        }
    }


    private fun onSwiped() {
        val callback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                val item = adapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteNote(item)
            }

        }

     val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(binding.recyclerview)
    }

}

