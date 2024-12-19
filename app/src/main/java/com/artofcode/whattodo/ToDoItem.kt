package com.artofcode.whattodo

data class ToDoItem(
    val id: Int,
    val tittle: String,
    val isDone: Boolean=false
)