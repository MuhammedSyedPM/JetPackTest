package com.example.mystartjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.mystartjetpack.ui.Nav
import com.example.mystartjetpack.ui.theme.MyStartJetPackTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStartJetPackTheme {
                val navController = rememberNavController()
                Nav(navController)
            }
        }
    }
}


