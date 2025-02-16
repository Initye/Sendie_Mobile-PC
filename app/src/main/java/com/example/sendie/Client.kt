package com.example.sendie

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.Socket

fun ConnectToServer(ip: String) {
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val client = Socket(ip, 9999)
            client.outputStream.write("Hello from the client!".toByteArray())
            client.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun main() {
    ConnectToServer("127.0.0.1")
}