package com.example.mystartjetpack.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystartjetpack.common.Resource
import com.example.mystartjetpack.repository.CityRepository
import com.example.mystartjetpack.stateholder.CityStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CityViewModel @Inject constructor(private val repository: CityRepository) : ViewModel() {


     private val cityList = mutableStateOf(CityStateHolder())


    init {
        cityList.value = CityStateHolder(isLoading = true)
        getCityDetails()
    }

    private fun getCityDetails() = viewModelScope.launch(Dispatchers.IO) {
        when (val result = repository.getCityList()) {
            is Resource.Success -> {
                cityList.value =  CityStateHolder(datas = result.data)
            }

            is Resource.Error -> {
                cityList.value = CityStateHolder(error = result.message.toString())
            }
        }
    }
    fun onButtonClick() {
        getCityDetails()
    }
}

