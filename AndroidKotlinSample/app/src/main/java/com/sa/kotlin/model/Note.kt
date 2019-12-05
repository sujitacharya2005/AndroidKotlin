package com.sa.kotlin.model

import androidx.room.Entity

@Entity(tableName = "note_table")
data class Note (
    val title:String,
    val description:String,
    val priority:Int
)