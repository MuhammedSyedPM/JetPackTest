package com.example.mystartjetpack.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mystartjetpack.R
import com.google.android.gms.wallet.button.ButtonConstants


@Composable
fun Continue(navController: NavHostController) {
    BoxWithBackground(Modifier, R.drawable.welcom)
    {
        Column {

            Column(modifier = Modifier
                .padding(20.dp)
                .weight(2f)) {
                Text(text = "HELLO", fontSize = 40.sp, fontWeight = FontWeight.Bold)
                Text(text = "Loreum Ipsium Welcome")

            }

            Column(modifier = Modifier
                .padding(20.dp)
                .weight(1f)) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {},
                    enabled = true,
                ) {
                    Text(text = "Sign In")
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {},
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                )
                     {
                    Text(text = "Sign Up", color = Color.Black)
                }
            }

        }

    }
}

@Composable
fun BoxWithBackground(
    modifier: Modifier = Modifier,
    bgImageResId: Int,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        val painter = painterResource(id = bgImageResId)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun ContinuePreview() {
    var context = LocalContext.current
    var navController = NavHostController(context)
    Continue(navController)
}
