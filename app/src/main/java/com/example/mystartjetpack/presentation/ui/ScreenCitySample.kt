package com.example.mystartjetpack.presentation.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.mystartjetpack.presentation.viewmodel.CityViewModelState
import com.example.mystartjetpack.repository.CityRepository



@Composable
fun CityScreenSample(viewModel: CityViewModelState = hiltViewModel()) {
    val cityListState by viewModel.cityListState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            cityListState.isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            cityListState.error.isNotBlank() -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = cityListState.error)
                }
            }

        }
        cityListState.datas?.let {
            LazyColumn {
                items(cityListState.datas!!.size) {
                    CityItem(it = cityListState.datas!![it])
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CitySamplePreview() {
    val context = LocalContext.current
    val navController = rememberNavController()
    var repository = CityRepository(api = null,null)
    val testViewModel = CityViewModelState(repository) // Provide a mock ViewModel
    CityScreenSample(testViewModel)
}

