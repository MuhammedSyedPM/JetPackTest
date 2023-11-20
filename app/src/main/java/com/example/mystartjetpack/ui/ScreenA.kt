package com.example.mystartjetpack.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mystartjetpack.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun ScreenA(navController: NavHostController) {
    val usernameState = remember { mutableStateOf(TextFieldValue()) }
    val passwordState = remember { mutableStateOf(TextFieldValue()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Red)
                        .weight(1f)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(), text = "Header", textAlign = TextAlign.Center
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.Yellow),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Image(
                            modifier = Modifier.fillMaxWidth(),
                            painter = painterResource(id = R.drawable.baseline_lock_24),
                            contentDescription = "image",
                        )
                    }
                    SimpleTextField(textState = usernameState, label = "Username")
                    Spacer(modifier = Modifier.height(10.dp))
                    SimpleTextField(textState = passwordState, label = "Password")
                    Spacer(modifier = Modifier.height(10.dp))
                    SubmitButton(navController, usernameState, passwordState)
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green)
                        .weight(1f)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(), text = "Footer", textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField(textState: MutableState<TextFieldValue>, label: String) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textState.value,
        onValueChange = { textState.value = it },
        label = { Text("Enter your $label here") }
    )
}

@Composable
fun SubmitButton( 
    click: NavHostController,
    usernameState: MutableState<TextFieldValue>,
    passwordState: MutableState<TextFieldValue>
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            val products = listOf(
                Product("Product 1", "100"),
                Product("Product 2", "200"),
                Product("Product 3", "300"),
                Product("Product 1", "100"),
                Product("Product 2", "200"),
                Product("Product 3", "300"),
            )
            // Navigate to the next screen (e.g., "B")
            click.navigate("C"){
                
            }

            // Show a toast message with the username and password
            showLoginInfo(usernameState.value.text, passwordState.value.text)
        }
    ) {
        Text(text = "Log in")
    }
}


@Composable
fun Dropdown() {


}
fun showLoginInfo(username: String, password: String) {
    GlobalScope.launch(Dispatchers.Main) {
        Toast.makeText(context, "Username: $username\nPassword: $password", Toast.LENGTH_SHORT).show()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var context = LocalContext.current
    var navController = NavHostController(context)
    ScreenA(navController)
}

enum class Role {
    ADMIN,
    SUPER_ADMIN,
    USER,
}