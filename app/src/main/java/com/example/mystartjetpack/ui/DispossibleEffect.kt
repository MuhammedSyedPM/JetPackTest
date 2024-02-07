package com.example.mystartjetpack.ui

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DisposableEffectExample() {
    var count by remember { mutableStateOf(0) }

    DisposableEffect(Unit) {
        // This block will execute when the composable is first composed or recomposed
        println("DisposableEffect executed")
        Log.d("MSD_Dis","DisposableEffect executed")

        // Update count every second
        val timer = object : CountDownTimer(Long.MAX_VALUE, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                count++
            }
            override fun onFinish() {}
        }
        timer.start()

        // Cleanup when the composable is removed from the composition
        onDispose {
            timer.cancel()
            println("DisposableEffect disposed")
            Log.d("MSD_Dis","DisposableEffect disposed")
        }
    }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Count: $count")
    }
}

@Preview
@Composable
fun PreviewDisposableEffectExample() {
    DisposableEffectExample()
}
