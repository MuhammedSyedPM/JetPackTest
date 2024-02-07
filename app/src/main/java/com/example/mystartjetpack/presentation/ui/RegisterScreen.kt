package com.example.mystartjetpack.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mystartjetpack.presentation.viewmodel.RegistrationViewModel
import com.example.mystartjetpack.repository.CityRepository
import com.example.mystartjetpack.ui.NormalTextField

@Composable
fun RegisterScreen(
    navController: NavHostController,
    registrationViewModel: RegistrationViewModel = hiltViewModel()
) {
    val usernameState = remember { mutableStateOf(TextFieldValue()) }
    val passwordState = remember { mutableStateOf(TextFieldValue()) }
    val roleState = remember { mutableStateOf(TextFieldValue()) }

    val registrationState by registrationViewModel.registrationState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            NormalTextField(textState = usernameState, label = "Username")
            NormalTextField(textState = passwordState, label = "Password")
            NormalTextField(textState = roleState, label = "Role")
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    registrationViewModel.register(
                        usernameState.value.text,
                        passwordState.value.text,
                        roleState.value.text
                    )
                }
            ) {
                Text(text = "Register")
            }
            when (registrationState) {
                is RegistrationState.Loading -> {
                    CircularProgressIndicator()
                }

                is RegistrationState.Success -> {
                    Text(text = (registrationState as RegistrationState.Success).message.toString(), color = Color.Red)
                }

                is RegistrationState.Error -> {
                    Text(text = (registrationState as RegistrationState.Error).error, color = Color.Red)
                }

                is RegistrationState.Idle -> {
                    // Handle the Idle state if needed
                }
            }

        }
        }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var context = LocalContext.current
    var navController = NavHostController(context)
    var repository = CityRepository(api = null, dataDao = null)
    val testViewModel = RegistrationViewModel(repository)
    RegisterScreen(navController, testViewModel)
}

