package com.example.todo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.db.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class ToDoViewModel: ViewModel() {

    val toDoDao = MainApplication.toDoDatabase.getToDoDao()

    val todoList : LiveData<List<ToDo>> = toDoDao.getAllToDo()


    @RequiresApi(Build.VERSION_CODES.O)
    fun addToDo(title : String){

        viewModelScope.launch(Dispatchers.IO){
        toDoDao.addToDo(ToDo(title = title, createdAt = Date.from(Instant.now())))
        }
    }

    fun deleteToDo(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            toDoDao.deleteToDo(id)
        }
    }
}