package com.example.todo

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.annotation.RequiresApi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val toDoViewModel = ViewModelProvider(this).get(ToDoViewModel::class.java)
        setContent {
            ToDoListPage(toDoViewModel)
        }
    }
}

