package com.example.tezora.domain.repository

import com.example.tezora.Uistate

interface AuthRepository {
    suspend fun Signuprepo(email: String, password: String): Uistate<String>

    suspend fun LoginRepo(email: String,password: String): Uistate<String>
}