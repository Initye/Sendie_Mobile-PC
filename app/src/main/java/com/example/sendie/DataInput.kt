package com.example.sendie

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun InputField(label: String, onValueChange: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange= {
            text = it
            onValueChange(it)
        },
        label = { Text(label) }
    )
}

@Composable
fun InsertIp(onIpEntered: (String) -> Unit) {
    InputField(label = "Server IP Address", onValueChange = onIpEntered)
}

@Composable
fun Message(isConnected: Boolean, onMsgEntered: (String) -> Unit) {
    InputField(label = if(isConnected) "Write a message" else "Server IP Address", onValueChange = onMsgEntered)
}

