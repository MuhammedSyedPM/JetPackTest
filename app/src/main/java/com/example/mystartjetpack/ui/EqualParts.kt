package com.example.mystartjetpack.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun EqualParts(navController: NavController) {
    val colors = listOf(Color.Red, Color.Green, Color.Blue)

    Row(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1.0f)
                .fillMaxSize()
                .background(colors[0])
        ) {
            Text("Hello")
        }
        Box(
            modifier = Modifier
                .weight(1.0f)
                .fillMaxSize()
                .background(colors[1])
        ){
            Text("2")
        }
        Box(
            modifier = Modifier
                .weight(1.0f)
                .fillMaxSize()
                .background(colors[2])
        ){
            Text("3")
        }

    }
}