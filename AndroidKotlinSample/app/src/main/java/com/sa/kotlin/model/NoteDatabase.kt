package com.sa.kotlin.model

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase :  RoomDatabase() {
    abstract fun noteDao() : NoteDao

    companion object  {
        @Volatile
        private var INSTANCE : NoteDatabase?= null

        fun getInstance(context:Context) : NoteDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }
        private fun buildDatabase(context: Context): NoteDatabase =
            Room.databaseBuilder(context.applicationContext,
                NoteDatabase::class.java, "note_database")
                .fallbackToDestructiveMigration()
                .addCallback(roomCallback)
                .build()

        private val roomCallback: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(INSTANCE!!).execute()
            }
        }

        private class PopulateDbAsyncTask (db: NoteDatabase) :
            AsyncTask<Void?, Void?, Void?>() {
            private val noteDao: NoteDao = db.noteDao()
            override fun doInBackground(vararg voids: Void?): Void? {
                noteDao.insert(Note("Title 1", "Description 1", 1))
                noteDao.insert(Note("Title 2", "Description 2", 2))
                noteDao.insert(Note("Title 3", "Description 3", 3))
                return null
            }

        }
    }
}