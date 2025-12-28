package com.example.tezora.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tezora.Uistate
import com.example.tezora.domain.Usecase.LoginUseCase
import com.example.tezora.domain.Usecase.signupusecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
private val signupusecase: signupusecase,
    private val  loginUseCase: LoginUseCase
    ): ViewModel() {

        private val _authState = MutableStateFlow<Uistate<String>>(Uistate.Idle)
    val authState: StateFlow<Uistate<String>> = _authState.asStateFlow()

    fun signup(email: String, password: String){
        _authState.value = Uistate.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = signupusecase(email,password)
                _authState.value = result

            }catch (e: Exception){
                _authState.value = Uistate.Failure(e.message ?: "SignUp Failed")
            }
        }
    }

    fun Login(email: String,password: String){
        _authState.value = Uistate.Loading

        viewModelScope.launch {
            try {
                val result = loginUseCase(email,password)
                _authState.value = result
            }catch (e: Exception){
                _authState.value = Uistate.Failure(e.message ?: " Login Failed")
            }
        }
    }
}