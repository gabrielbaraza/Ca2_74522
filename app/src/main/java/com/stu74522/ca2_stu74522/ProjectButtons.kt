package com.stu74522.ca2_stu74522

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ToScreen2Button(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text("Screen 2")
    }
}

@Composable
fun ToScreen3Button(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text("Screen 3")
    }
}

@Composable
fun ToScreen4Button(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text("Screen 4")
    }
}

@Composable
fun ToScreen5Button(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text("Screen 5")
    }
}



@Composable
fun ToHomeButton(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text("Home")
    }
}