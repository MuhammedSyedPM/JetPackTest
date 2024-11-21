package com.example.mystartjetpack.ui
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mystartjetpack.R
import com.example.mystartjetpack.presentation.viewmodel.CityViewModel
import com.example.mystartjetpack.repository.CityRepository


@Composable
fun Login(navController: NavHostController, cityViewModel: CityViewModel = hiltViewModel()) {

    val usernameState = remember { mutableStateOf(TextFieldValue()) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.2f) // Adjusted weight
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
                space()
                NormalTextField(textState = usernameState, label = "Password")
                space()
                LoginButton(text = "Sign In"){ navController.navigate("H") }

               space()
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
                    space()
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
                    text = "Don't have an Account? Please Sign Up",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    var repository = CityRepository(api = null,null)
    val testViewModel = CityViewModel(repository) // Provide a mock ViewModel
    Login(navController, testViewModel)
}


/**
OutlinedTextField(
value = "",
onValueChange = {},
label = { Text("User ID") },
modifier = Modifier
.fillMaxWidth()
.background(Color.White, shape = RoundedCornerShape(8.dp)), // Background color with shape
shape = RoundedCornerShape(8.dp) // Border shape (optional)
)**/