package com.example.mystartjetpack.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mystartjetpack.data.Data
import com.example.mystartjetpack.presentation.viewmodel.CityListViewModel
import com.example.mystartjetpack.repository.CityRepository
import com.example.mystartjetpack.showToast


@Composable
fun ScreenCity(
    navController: NavHostController,
    cityViewModel: CityListViewModel = hiltViewModel()
) {


    val result = cityViewModel.cityList.value

    LaunchedEffect(true) {
        cityViewModel.getCityDetails()
    }

    when {
        result.isLoading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        result.error.isNotBlank() -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = result.error)
            }
        }

    }
    result.datas?.let {
        LazyColumn {
            items(result.datas.size) {
                 CityItem(it = result.datas[it])
            }
        }
    }


}

@Composable
fun CityItem(it: Data) {
    var changedState by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable {
                changedState = true
            }
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(text = it.countryName)
        }
    }

    LaunchedEffect(changedState) {
        if (changedState) {
            changedState=false
            context.showToast("message")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CityPreview() {
    val context = LocalContext.current
    val navController = rememberNavController()
    var repository = CityRepository(api = null, dataDao = null)
    val testViewModel = CityListViewModel(repository) // Provide a mock ViewModel
    ScreenCity(navController, testViewModel)
}

