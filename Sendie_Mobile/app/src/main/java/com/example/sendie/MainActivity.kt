package com.example.sendie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
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
    var isConnected by remember { mutableStateOf(false) } //Variable that allows to change text on button when connected
    var isConnecting by remember { mutableStateOf(false) }

    var ip by remember {mutableStateOf("")}
    var mess by remember { mutableStateOf("") }

    if(!isIpEntered) { //if the value is set to true then show message textfield
        InsertIp {
            enteredIp -> ip = enteredIp
        }

    } else {
        Message(isConnected) {
            enteredMess -> mess = enteredMess
        }
    }

    ConnectionButton(
        clicked = clicked,
        onClick = {
            clicked = true

            if(!isConnected && !isConnecting) {
                isConnecting = true //Connection in progress

                ConnectToServer(ip, mess,
                    onSuccess = {
                      isConnected = true
                      isConnecting = false //Allows ui to change
                      isIpEntered = true
                    },
                    onFailure = {
                        isConnecting = false //Prevents ui from changing
                    })

            } else if (isConnected) { //If connected
                ConnectToServer(ip, mess, onFailure = {}, onSuccess = {})
            }
        },
         buttonText = if (isConnected) "Send Message" else "Connect"
    )
}



@Preview(showBackground = true)
@Composable
fun AppPreview() {
    SendieApp()
}