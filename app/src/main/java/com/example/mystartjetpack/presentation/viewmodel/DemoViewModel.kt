package com.example.mystartjetpack.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystartjetpack.common.Resource
import com.example.mystartjetpack.data.Data
import com.example.mystartjetpack.repository.CityRepository
import com.example.mystartjetpack.stateholder.CityStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**@HiltViewModel
class DemoViewModel @Inject constructor(private val repository: CityRepository) :
    ViewModel() {


        init {
            getCityDetails()
        }

    fun events(events: Event) {
        when (events) {
            Event.ButtonFourClick -> Log.d("MSD", "four")
            Event.ButtonThreeClick -> Log.d("MSD", "three")
            Event.ButtonTwoClick -> Log.d("MSD", "two")
            is Event.ButtonOneClick -> Log.d(
                "MSD",
                "one, data: ${events.usename} ${events.password}"
            )
        }

    }

    private val _cityListState = MutableStateFlow(CityStateHolder(isLoading = true))
    val cityListState: StateFlow<CityStateHolder> = _cityListState


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


}


sealed class Event {
    data class ButtonOneClick(var usename: String, var password: String) : Event()
    object ButtonTwoClick : Event()
    object ButtonThreeClick : Event()
    object ButtonFourClick : Event()


}**/



@HiltViewModel
class DemoViewModel @Inject constructor(private val repository: CityRepository) :
    ViewModel() {

    init {
        getCityDetails()
    }

    fun events(events: Event) {
        when (events) {
            Event.ButtonFourClick -> Log.d("MSD", "four")
            Event.ButtonThreeClick -> Log.d("MSD", "three")
            Event.ButtonTwoClick -> Log.d("MSD", "two")
            is Event.ButtonOneClick -> Log.d(
                "MSD",
                "one, data: ${events.username} ${events.password}"
            )
        }
    }

    private val _cityListState = MutableStateFlow<CityListState>(CityListState.Loading)
    val cityListState: StateFlow<CityListState> = _cityListState

    private fun getCityDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getCityList()) {
                is Resource.Success -> {
                    _cityListState.value = CityListState.DataLoaded(result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _cityListState.value = CityListState.Error(result.message ?: "Unknown error")
                }
                else -> {
                    // Handle other states if necessary
                }
            }
        }
    }
}

sealed class Event {
    data class ButtonOneClick(var username: String, var password: String) : Event()
    object ButtonTwoClick : Event()
    object ButtonThreeClick : Event()
    object ButtonFourClick : Event()
}

sealed class CityListState {
    object Loading : CityListState()
    data class Error(val message: String) : CityListState()
    data class DataLoaded(val cities: List<Data>) : CityListState()
}


