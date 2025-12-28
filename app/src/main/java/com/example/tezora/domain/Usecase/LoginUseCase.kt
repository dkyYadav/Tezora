package com.example.tezora.domain.Usecase

import com.example.tezora.Uistate
import com.example.tezora.domain.repository.AuthRepository

class LoginUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(email: String,password : String): Uistate<String>{
        return repository.LoginRepo(email,password)
    }
}

