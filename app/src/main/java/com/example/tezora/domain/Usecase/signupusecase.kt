package com.example.tezora.domain.Usecase

import com.example.tezora.Uistate
import com.example.tezora.domain.repository.AuthRepository

class signupusecase(
    val repository: AuthRepository
){
    suspend operator fun invoke(email: String, password : String): Uistate<String> {

        // Email cannot be empty
        if (email.isBlank()){
            return Uistate.Failure(error = "Email cannot be empty")
        }
        //  Password chhota nahi hona chahiye
        if (password.length <6){
            return Uistate.Failure("Password must be at least 6 Characters")
        }

        if (!email.contains("@") || !email.contains(".")){
            return Uistate.Failure("Invalid email format")
        }


        return repository.Signuprepo(email,password)
    }

}