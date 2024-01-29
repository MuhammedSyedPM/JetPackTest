package com.example.mystartjetpack.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mystartjetpack.R


@Composable
fun ScreenProduct(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().padding(10.dp))
    {

        Card {
            Row {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .weight(1f)) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.baseline_account_circle_24),
                        contentDescription = stringResource(id = R.string.app_name)
                    )
                }
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)) {
                    Text(text = "Ernakulam" , modifier = Modifier.align(Alignment.End).padding(10.dp))
                    Text(text = "Adv. John Doe",fontSize = 25.sp,color= Color.Blue)
                    Text(text = "Practicing in Kerala High Court ")
                    Text(text = "3.6",fontSize = 20.sp)
                    Row (modifier = Modifier.fillMaxWidth()) {
                        Text(text = "156 Client",fontSize = 15.sp)
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(text = "View rating")
                    }

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenProductPreview() {
    var context = LocalContext.current
    var navController = NavHostController(context)
    ScreenProduct(navController)
}









