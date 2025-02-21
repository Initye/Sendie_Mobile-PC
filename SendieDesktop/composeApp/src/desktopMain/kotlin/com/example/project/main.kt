package com.example.project  // This should match the package of your project files

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "SendieDesktop",
    ) {
        App()  // This will now correctly refer to your App composable
    }
}
