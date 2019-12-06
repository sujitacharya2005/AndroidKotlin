package com.sa.kotlin


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
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
        } else {
            Toast.makeText(this, "Note not saved", Toast.LENGTH_SHORT).show()
        }
    }
}

