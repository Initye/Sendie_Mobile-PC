package com.example.sendie

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.Socket

fun ConnectToServer(ip: String, mess: String) {
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val client = Socket(ip, 9999)
            val output = client.outputStream
            client.outputStream.write(mess.toByteArray()) //Convert message to bytes
            output.flush() //Making sure that data is sent
            client.close() //Without this the message takes a long time to arrive, prob inf loop
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}



fun main() {
    ConnectToServer("127.0.0.1", "")
}