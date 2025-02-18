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
fun InsertIp(onIpEntered: (String) -> Unit) {
    var ipAddress by remember { mutableStateOf(TextFieldValue(""))}
    TextField(
        value = ipAddress,
        onValueChange = {
            ipAddress = it
            onIpEntered(ipAddress.text) },
        label = { Text("Server IP Address") }
    )
}

@Composable
fun Message(onMsgEntered: (String) -> Unit) {
    var msg by remember { mutableStateOf(TextFieldValue("")) }

    TextField (
        value = msg,
        onValueChange = {
            msg = it
            onMsgEntered(msg.text)
        },
        label = { Text("Write a message") }
    )
}

