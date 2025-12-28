package com.example.tezora

sealed class Uistate<out T>{
    data object Idle : Uistate<Nothing>()
    data object Loading : Uistate<Nothing>()
    data class Success<T>(val data: T) : Uistate<T>()
    data class Failure(val error : String) : Uistate<Nothing>()
}