package com.example.sendie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun SendieApp(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        ConnectItem()
    }
}

@Composable
fun ConnectItem() {
    var clicked by remember { mutableStateOf(false) }
    var isIpEntered by remember { mutableStateOf(false) }

    var ip by remember {mutableStateOf("")}
    var mess by remember { mutableStateOf("") }

    if(!isIpEntered) { //if the value is set to true then show message texfield
        InsertIp {
            enteredIp -> ip = enteredIp
        }

    } else {
        Message {
                enteredMess -> mess = enteredMess
        }
    }

    ConnectionButton(
        clicked = clicked,
        onClick = {
            clicked = true
            isIpEntered = true
            ConnectToServer(ip, mess)
        }
    )
}



@Preview
@Composable
fun AppPreview() {
    SendieApp()
}