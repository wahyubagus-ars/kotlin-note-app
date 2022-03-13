package com.example.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.dao.NoteDao
import com.example.notes.entities.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    companion object{
        var noteDatabase:NoteDatabase? = null

        @Synchronized
        fun getDatabase(context:Context) : NoteDatabase {
            if (noteDatabase != null){
                noteDatabase = Room.databaseBuilder(
                    context, NoteDatabase::class.java, "notes.db"
                ).build()
            }

            return noteDatabase!!
        }
    }

    abstract fun noteDao():NoteDao
}