package com.example.mystartjetpack.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystartjetpack.common.Resource
import com.example.mystartjetpack.repository.CityRepository
import com.example.mystartjetpack.stateholder.CityStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CityViewModelState @Inject constructor(private val repository: CityRepository) : ViewModel() {

    private val _cityListState = MutableStateFlow(CityStateHolder(isLoading = true))
    val cityListState: StateFlow<CityStateHolder> = _cityListState

    init {
     //   getCityDetails()
    }

    private fun getCityDetails() = viewModelScope.launch(Dispatchers.IO) {
        when (val result = repository.getCityList()) {
            is Resource.Success -> {
                _cityListState.value = CityStateHolder(datas = result.data)
            }
            is Resource.Error -> {
                _cityListState.value = CityStateHolder(error = result.message.toString())
            }
            else -> {
                // Handle other states if necessary
            }
        }
    }

    fun onButtonClick() {
        getCityDetails()
    }
}
