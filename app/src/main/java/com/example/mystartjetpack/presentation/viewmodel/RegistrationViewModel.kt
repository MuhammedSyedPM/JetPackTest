package com.example.mystartjetpack.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystartjetpack.data.User
import com.example.mystartjetpack.presentation.ui.RegistrationState
import com.example.mystartjetpack.repository.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegistrationViewModel @Inject constructor(private val repository: CityRepository) : ViewModel() {
    private val _registrationState = MutableStateFlow<RegistrationState>(RegistrationState.Idle)
    val registrationState: StateFlow<RegistrationState> = _registrationState

    fun register(username: String, password: String, role: String) {
        if (validateFields(username, password, role)) {
            performRegistration(username, password, role)
        }
    }

    private fun validateFields(username: String, password: String, role: String): Boolean {
        return if (username.isEmpty() || password.isEmpty() || role.isEmpty()) {
            _registrationState.value = RegistrationState.Error("Please fill in all fields.")
            false
        } else {
            true
        }
    }

    private fun performRegistration(username: String, password: String, role: String) {
        _registrationState.value = RegistrationState.Loading(true)
        viewModelScope.launch {
            var registerData= mutableListOf<User>()
            registerData.add(User(username,password))
           repository.insertData(registerData)
            _registrationState.value = RegistrationState.Success("Data inserted Successfully")
        }
    }
}
