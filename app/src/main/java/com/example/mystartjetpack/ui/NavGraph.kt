package com.example.mystartjetpack.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mystartjetpack.presentation.CityViewModel

@Composable
fun Nav(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "G") {

        composable("A") {
            ScreenA(navController)
        }
        composable("B") {
            ScreenB(navController)
        }
        composable("C") {
            ScreenC(navController)
        }
        composable("E") {
            EqualParts(navController)
        }
        composable("F") {
           Continue(navController)
        }
        composable("G") {
            Login(navController)
        }
        composable("H") {
            ScreenCity(navController)
        }

    }
}