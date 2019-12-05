package com.sa.kotlin.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version =1
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
                .build()
    }
}