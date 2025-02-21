package com.example.project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sendie.getLocalIpAddress
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket
import java.net.SocketException
import kotlin.concurrent.thread

fun getLocalIpAddress(): String { //For testing
    return try {
        DatagramSocket().use { socket ->
            socket.connect(InetAddress.getByName("8.8.8.8"), 80) // Connect to Google's DNS
            socket.localAddress.hostAddress // Get the  IP address
        }
    } catch (e: SocketException) {
        "Unable to determine IP"
    }
}

fun startServer(onMessageReceived: (String) -> Unit, onIpAddressReady: (String) -> Unit) {
    thread { //Background Thread so that server logic does not block UI thread
        val server = ServerSocket(9999) //Server that listens on port 9999
        val ip = getLocalIpAddress() // Get local IP address

        //Server details in terminal
        println("Server is working on port ${server.localPort}")
        println("Server is working on IP: $ip")

        val client = server.accept()
        println("Client connected: ${client.inetAddress.hostAddress}")

        // Listen for client connections
        while (true) {
            val client = server.accept()
            //Handle communication with client
            handleClientMessages(client, onMessageReceived)
        }
    }

}

//Messages from the Client
fun handleClientMessages(client: Socket, onMessageReceived: (String) -> Unit) {
    try {
        //Read from client's input stream
        val input = BufferedReader(InputStreamReader(client.getInputStream()))

        //Read Client messages
        while (true) {
            val message = input.readLine()
            if (message == null) break
            onMessageReceived(message) //Update the UI with the received message
        }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    var isServerRunning by remember { mutableStateOf(false) } //Track if server is running
    var messages by remember { mutableStateOf(listOf<String>()) } //Store messages



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        DesignButton(isServerRunning, messages, { message ->
            // Update the list of messages when the server receives a new message
            messages = messages + message
        })
        // Pass state variables to the Messages composable
        Messages(messages)
    }
}

@Composable
fun DesignButton(isServerRunning: Boolean, messages: List<String>, onMessagesUpdated: (String) -> Unit) {
    // Button that starts the server when clicked
    Button(onClick = {
        if (!isServerRunning) {
            // Set the server running
            startServer(onMessagesUpdated) { message ->
                // When a message is received, update the message list
                onMessagesUpdated(message)
            }
        }
    },
    ) {
        Text("Start Server")
    }

}

@Composable
fun Messages(messages: List<String>) {
    // Display list of received messages
    Text("Client said:")
    // Display each message one by one
    messages.forEach { message ->
        Text(message)
    }
}
