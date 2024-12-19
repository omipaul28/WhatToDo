package com.artofcode.whattodo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToDoItemCard(todoItem:ToDoItem,
                 onToggleDone:(ToDoItem)->Unit,
                 onDelete:(ToDoItem)->Unit
) {
Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .background(Color.White, RoundedCornerShape(8.dp))
        .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
) {
    Checkbox(checked = todoItem.isDone, onCheckedChange = {onToggleDone(todoItem)})
    
    Text(text = todoItem.tittle,
        modifier = Modifier
            .padding(4.dp)
            .weight(1f),
        fontSize = 16.sp,
        fontFamily = FontFamily.Default
        )
    IconButton(onClick = { onDelete(todoItem) }) {
        Icon(Icons.Default.Delete , contentDescription ="Delete" )
    }
}
}


@Composable
fun AddToDoItem(onAdd:(String)->Unit){
    var txt by remember { mutableStateOf("")}
Row (modifier=Modifier.padding(8.dp)){
    OutlinedTextField(value = txt,
        onValueChange = {txt=it},
        modifier = Modifier.weight(1f),
        label ={Text("New To-Do")})

    Button(onClick = {
        if(txt.isNotBlank()){
            onAdd(txt)
            txt=""
        } },
        modifier=Modifier.padding(8.dp)
    ) {
        Text(text = "Add")
    }
}
}