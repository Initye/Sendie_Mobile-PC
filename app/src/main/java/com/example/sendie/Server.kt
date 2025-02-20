package com.example.sendie

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket
import java.net.SocketException

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


fun main() {
    val server = ServerSocket(9999)
    val ip = getLocalIpAddress() // Get local IP address

    println("Server is working on port ${server.localPort}")
    println("Server is working on IP: $ip")

    val client = server.accept()
    println("Client connected: ${client.inetAddress.hostAddress}")

    while (true) {
        val client = server.accept()

        ClientMessages(client)
    }
}

// Function to handle communication with the client
fun ClientMessages(client: Socket) {
    try {
        val input = BufferedReader(InputStreamReader(client.getInputStream()))

        while (true) {
            val message = input.readLine()

            if(message == null) { //to avoid infinite loop
                break
            }

            println("Client: $message")
        }

    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}

