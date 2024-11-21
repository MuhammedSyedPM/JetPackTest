package com.example.mystartjetpack.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mystartjetpack.repository.CityRepository
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mystartjetpack.presentation.viewmodel.CityListState
import com.example.mystartjetpack.presentation.viewmodel.DemoViewModel
import com.example.mystartjetpack.ui.context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun ScreenDemo(
    navController: NavHostController,
    viewModel: DemoViewModel = hiltViewModel()
) {
    context= LocalContext.current
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxSize()
            .padding(all = 16.dp)
            ,Arrangement.Center) {
            Text("Hello",Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            Button(
                modifier=Modifier.fillMaxWidth(),
                onClick = {
                    handleClick()},
                colors = ButtonDefaults.buttonColors(Color.Companion.Black),
            ) {
                Text("Click Me")
            }

        }
    }



}

fun handleClick() {
    CoroutineScope(Dispatchers.Main).launch {
        Toast.makeText(context, "Button clicked!", Toast.LENGTH_SHORT).show()
    }
}

@Preview(showBackground = true)
@Composable
fun CityDemoPreview() {
    val context = LocalContext.current
    val navController = rememberNavController()
    var repository = CityRepository(api = null, dataDao = null)
    val testViewModel = DemoViewModel(repository)
    ScreenDemo(navController, testViewModel)
}

