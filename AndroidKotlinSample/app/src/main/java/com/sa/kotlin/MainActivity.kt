package com.sa.kotlin


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sa.kotlin.model.Note
import com.sa.kotlin.ui.AddNoteActivity
import com.sa.kotlin.ui.NoteAdapter
import com.sa.kotlin.ui.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var noteViewModel: NoteViewModel

    companion object {
        const val ADD_NOTE_REQUEST = 1
        const val EDIT_NOTE_REQUEST = 2
        private val TAG = MainActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonAddNote = findViewById<FloatingActionButton>(R.id.button_add_note)
        buttonAddNote.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, AddNoteActivity::class.java)
                startActivityForResult(intent, ADD_NOTE_REQUEST)
            }
        })

        val noteAdapter = NoteAdapter()
        with(recycler_view) {
            adapter = noteAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        noteViewModel.allNotes
            .observe(this,
                Observer<List<Note>> { notes ->
                    noteAdapter.setNotes(notes)
                })
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                noteViewModel.delete(noteAdapter.getNoteAt(viewHolder.adapterPosition))
                Toast.makeText(this@MainActivity, "Note deleted", Toast.LENGTH_SHORT).show()
            }
        }).attachToRecyclerView(recycler_view)

        noteAdapter.setOnItemClickListener(object : NoteAdapter.OnItemClickListener {
            override fun onItemClick(note: Note) {
                val intent = Intent(this@MainActivity, AddNoteActivity::class.java)
                intent.putExtra(AddNoteActivity.EXTRA_ID, note.id)
                intent.putExtra(AddNoteActivity.EXTRA_TITLE, note.title)
                intent.putExtra(AddNoteActivity.EXTRA_DESCRIPTION, note.description)
                intent.putExtra(AddNoteActivity.EXTRA_PRIORITY, note.priority)
                startActivityForResult(intent, EDIT_NOTE_REQUEST)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_NOTE_REQUEST && resultCode == Activity.RESULT_OK) {
            with(data!!) {
                val title = getStringExtra(AddNoteActivity.EXTRA_TITLE)
                val description = getStringExtra(AddNoteActivity.EXTRA_DESCRIPTION)
                val priority = getIntExtra(AddNoteActivity.EXTRA_PRIORITY, 1)
                val note = Note(title, description, priority)
                noteViewModel.insert(note)
            }


            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show()
        }
        else if (requestCode == EDIT_NOTE_REQUEST && resultCode == RESULT_OK) {
            val id = data?.getIntExtra(AddNoteActivity.EXTRA_ID, -1);

            if (id == -1) {
                Toast.makeText(this, "Note can't be updated", Toast.LENGTH_SHORT).show();
                return;
            }

            val title = data?.getStringExtra(AddNoteActivity.EXTRA_TITLE);
            val description = data?.getStringExtra(AddNoteActivity.EXTRA_DESCRIPTION);
            val priority = data?.getIntExtra(AddNoteActivity.EXTRA_PRIORITY, 1);

            val note = Note(title!!, description!!, priority!!);
            note.id = (id!!);
            noteViewModel.update(note);

            Toast.makeText(this, "Note updated", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Note not saved", Toast.LENGTH_SHORT).show()
        }
    }



}

