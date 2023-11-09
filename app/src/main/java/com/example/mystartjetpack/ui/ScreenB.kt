package com.example.mystartjetpack.ui

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mystartjetpack.showToast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalContext

lateinit var context:Context

val products = listOf(
    Product("Product 1", "100"),
    Product("Product 2", "200"),
    Product("Product 3", "300"),
    Product("Product 1", "100"),
    Product("Product 2", "200"),
    Product("Product 3", "300"),
)

@Composable
fun ScreenB(navController: NavHostController) {
    context= LocalContext.current
    LazyColumnWithProducts()
}

@Composable
fun ProductItem(product: Product) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable {
                context.showToast(product.name)
            }
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(text = product.name)
            Text(text = product.price)
        }
    }
}

@Composable
fun LazyColumnWithProducts() {
    LazyColumn {
        items(products) { product ->
            ProductItem(product)
        }
    }
}

data class Product(val name: String, val price: String)
