package com.example.mystartjetpack.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun LoginButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
        onClick = {
            onClick()
        },
        enabled = true,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
    ) {
        Text(text = "Sign In", modifier = androidx.compose.ui.Modifier.padding(10.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NormalTextField(textState: MutableState<TextFieldValue>, label: String) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textState.value,
        onValueChange = { textState.value = it },
        label = { Text("Enter your $label here") }
    )
}


@Composable
fun RoundedColumn(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Box(
        modifier = modifier
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(16.dp))
            .padding(10.dp)
    ) {
        Column {
            content()
        }
    }
}

@Composable
fun space(dp: Dp = 10.dp) {
    Spacer(modifier = Modifier.height(dp))
}





