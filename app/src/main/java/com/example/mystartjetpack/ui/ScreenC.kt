package com.example.mystartjetpack.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mystartjetpack.showToast

@Composable
fun ScreenC(navController: NavHostController) {

    val products = navController.currentBackStackEntry?.arguments?.get("products") as? List<Product>
    Column(modifier = Modifier.fillMaxSize()
    , verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen C", fontSize = 64.sp)
        Spacer(modifier = Modifier.height(45.dp))
        Button(onClick = {
         //  context?.showToast(products.toString())
        }) {
            Text(text = "Go to screen A", fontSize = 40.sp)
        }
        
    }
}