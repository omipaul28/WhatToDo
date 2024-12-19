package com.artofcode.whattodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artofcode.whattodo.ui.theme.WhatToDoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoApp()
        }
    }
}

@Composable
fun ToDoApp(){
    val todoItems= remember { mutableStateListOf<ToDoItem>()}
    var nextID by remember { mutableStateOf(0)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        AddToDoItem{
            tittle-> todoItems.add(ToDoItem(id = nextID++, tittle=tittle))
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn{
            items(todoItems){
                item ->  ToDoItemCard(
                todoItem = item,
                onToggleDone = { item -> item.isDone = !item.isDone },
                onDelete ={item -> todoItems.remove(item)} )
            }
        }
    }
}