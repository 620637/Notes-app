package com.example.todo.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todo.ToDo

@Dao
interface ToDoDao {

    @Query("SELECT * FROM ToDo")
    fun getAllToDo() : LiveData<List<ToDo>>

    @Insert
    fun addToDo(toDo: ToDo)

    @Query("Delete FROM ToDo where id = :id")
    fun deleteToDo(id : Int)

}