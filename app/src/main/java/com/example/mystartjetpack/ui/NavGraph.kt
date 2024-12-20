package com.example.mystartjetpack.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mystartjetpack.presentation.ui.CityScreenSample
import com.example.mystartjetpack.presentation.ui.RegisterScreen
import com.example.mystartjetpack.presentation.ui.ScreenCity
import com.example.mystartjetpack.presentation.ui.ScreenDemo
import com.example.mystartjetpack.ui.tutorial.ScreenD

@Composable
fun Nav(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "H") {

        composable("D") {
            ScreenD(navController)
        }

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
        composable("I"){
           // DisposableEffectExample()
           // CityScreenSample()
           // RegisterScreen(navController = navController)
            ScreenDemo(navController = navController)
        }

    }
}