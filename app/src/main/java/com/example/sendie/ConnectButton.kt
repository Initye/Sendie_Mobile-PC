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
    Button(onClick = onClick) {
        Text("Connect")
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    ConnectionButton(clicked = false, onClick = {})
}

