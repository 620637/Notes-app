package com.example.todo.db
import com.example.todo.ToDo

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(entities = [ToDo::class], version = 1)
@TypeConverters(converters::class)
abstract class ToDoDatabase : RoomDatabase() {

    companion object{
        const val NAME = "Todo_DB"
    }

    abstract fun getToDoDao(): ToDoDao
}