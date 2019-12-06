package com.sa.kotlin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sa.kotlin.R
import com.sa.kotlin.model.Note
import kotlinx.android.synthetic.main.note_item.view.*


class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var listener: OnItemClickListener? = null

    internal var notes: List<Note> = ArrayList()
    fun setNotes(notes1: List<Note>){
            notes = notes1
            notifyDataSetChanged()
    }

    fun getNoteAt(position: Int): Note =
         notes[position]


    //by default nested class is static , use inner to access data member of outer class
    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item : Note) = with(itemView) {
            text_view_title.text = item.title
            text_view_description.text = item.description
            text_view_priority.text = "${item.priority}"
            setOnClickListener {
                val position = adapterPosition
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(notes[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder =
        NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false))

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = holder.bind(notes[position])
    interface OnItemClickListener {
        fun onItemClick(note: Note)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}