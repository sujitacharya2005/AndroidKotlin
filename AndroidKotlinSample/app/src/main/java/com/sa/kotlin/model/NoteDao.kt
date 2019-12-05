package com.sa.kotlin.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert
    fun insert(note:Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("DELETE FROM note_table")
    fun  deleteAllNotes()

    @Query("Select * From note_table ORDER BY priority DESC")
    fun getAllNotes() : LiveData<List<Note>>
}