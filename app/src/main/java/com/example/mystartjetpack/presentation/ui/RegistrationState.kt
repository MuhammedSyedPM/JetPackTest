package com.example.mystartjetpack.presentation.ui

sealed class RegistrationState {
    data class Loading(val loading: Boolean) : RegistrationState()
    data class Success(val message: String) : RegistrationState()
    data class Error(val error: String) : RegistrationState()

    object Idle : RegistrationState()
}