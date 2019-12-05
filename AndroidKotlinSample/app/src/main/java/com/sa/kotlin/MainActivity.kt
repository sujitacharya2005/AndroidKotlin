package com.sa.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sa.kotlin.model.Note
import com.sa.kotlin.model.NoteDatabase
import com.sa.kotlin.ui.NoteAdapter
import com.sa.kotlin.ui.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: NoteViewModel

    companion object {
        private val TAG = MainActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter1 = NoteAdapter()
        with(recycler_view) {
            adapter = adapter1
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        viewModel.allNotes
            .observe(this,
                Observer<List<Note>> { notes ->
                    adapter1.setNotes(notes)
                })



    }
}

