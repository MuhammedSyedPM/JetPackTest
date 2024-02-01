package com.example.mystartjetpack.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mystartjetpack.R
import com.example.mystartjetpack.presentation.CityViewModel
import com.example.mystartjetpack.repository.CityRepository


@Composable
fun Login(navController: NavHostController,  cityViewModel: CityViewModel = hiltViewModel()) {

   // val cityResult by cityViewModel.cityResult
    val usernameState = remember { mutableStateOf(TextFieldValue()) }
    Box()
    {
        Column {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.5f)
            ) {
                val painter = painterResource(id = R.drawable.header)
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )

            }

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .weight(2f),
                Arrangement.Center
            ) {


                NormalTextField(textState = usernameState, label = "Username")
                NormalTextField(textState = usernameState, label = "Password")
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {

                     //   cityViewModel.onButtonClick()
                              navController.navigate("H")


                    },
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    Text(text = "Sign In", modifier = Modifier.padding(10.dp))
                }

              //  cityResult?.let { callApi(it,navController) }

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Forgot Password?",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center

                )


            }

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .weight(1f)
            ) {


                Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center) {
                    RoundedColumn {
                        Row {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null,
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text("Sign Up")
                        }


                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    RoundedColumn {
                        Row {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null,
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text("Sign Up")
                        }


                    }


                }
                Text(
                    text = "Dont have an Account?. please SignUp",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }


        }


      
    }



}

@Composable
fun callApi(cityResult: CityResult, navController: NavHostController) {
    when(cityResult){
        CityResult.ButtonClick -> Text("Button Click")
        is CityResult.Error -> Text("Error")
        CityResult.Loading -> CircularProgressIndicator()
        is CityResult.Success -> {
            navController.navigate("H")
        }
    }
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

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    val context = LocalContext.current
    val navController = rememberNavController()
    var repository = CityRepository(api = null)
    val testViewModel = CityViewModel(repository) // Provide a mock ViewModel
    Login(navController, testViewModel)
}

