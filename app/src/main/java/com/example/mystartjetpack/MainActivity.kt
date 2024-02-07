package com.example.mystartjetpack

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.example.mystartjetpack.ui.Nav
import com.example.mystartjetpack.ui.theme.MyStartJetPackTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var i=0
    var change=false
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
           MyStartJetPackTheme {
                val navController = rememberNavController()
                Nav(navController)


            }
           // i++
            var  changedState by remember {
            mutableStateOf(false)
        }


            Column {/**
                val sc= rememberCoroutineScope()
                i++
                LaunchedEffect(key1 = changedState, block = { //  i++
                    Log.d("MSD","$i")})


                sc.launch{
                   i++
                }
                DisposableEffect(key1 = changedState, ){
                    i++
                    Log.d("MSD","$i")
                    onDispose {

                    }
                }



                var text by remember { mutableStateOf("Hello, Jetpack Compose!") }
                Button(onClick = {
                    text += "#"
                    i++
                    changedState=!changedState
                }) {

                    Text(text = "$text${i}")

                }

                Button(onClick = {    i++
                     changedState=!changedState}) {

                }
              **/
            }

        }
    }
}


