package com.example.sendie

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ConnectionButton(
    clicked: Boolean,
    onClick: () -> Unit
) {
    if(!clicked) {
        Button(onClick = onClick) {
            Text("Connect")
        }
    } else {
        Button(onClick = onClick) {
            Text("Send Message")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    ConnectionButton(clicked = false, onClick = {})
}

