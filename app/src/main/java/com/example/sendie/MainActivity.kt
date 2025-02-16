package com.example.sendie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SendieApp()
        }
    }
}

@Composable
fun SendieApp() {
    Column() {
        ConnectItem()
    }
}

@Composable
fun ConnectItem() {
    var clicked by remember { mutableStateOf(false) }
    var ip by remember {mutableStateOf("")}

    InsertIp {
        enteredIp -> ip = enteredIp
    }

    ConnectionButton(
        clicked = clicked,
        onClick = {
            clicked = true
            ConnectToServer(ip)
        }
    )
}



@Preview
@Composable
fun display() {
    SendieApp()
}