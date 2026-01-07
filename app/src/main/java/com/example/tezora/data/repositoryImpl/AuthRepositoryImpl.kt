package com.example.tezora.data.repositoryImpl

import android.util.Log
import com.example.tezora.Uistate
import com.example.tezora.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl(
    private val firebaseAuth: FirebaseAuth
): AuthRepository {

       override suspend fun Signuprepo(email: String, password: String): Uistate<String> {
        return try {
            Log.d("AuthRepositoryImpl", "Starting signup for: $email")
            firebaseAuth
                .createUserWithEmailAndPassword(email,password)
                .await()
            Log.d("AuthRepositoryImpl", "Account created successfully, current user: ${firebaseAuth.currentUser?.email}")

            // Sign out the user immediately after account creation
            // User should manually log in after registration
           firebaseAuth.signOut()
            Log.d("AuthRepositoryImpl", "User signed out after signup, current user: ${firebaseAuth.currentUser}")

            Uistate.Success("Signup successful")

        }catch (e: Exception){
            Log.e("AuthRepositoryImpl", "Signup failed: ${e.message}", e)
            Uistate.Failure(e.localizedMessage ?: "Unknown error during signup")
        }
    }

    override suspend fun LoginRepo(
        email: String,
        password: String
    ): Uistate<String> {
        return try {
            Log.d("AuthRepositoryImpl", "Starting Login for: $email")
            firebaseAuth.signInWithEmailAndPassword(email,password).await()
            Uistate.Success("Login successful") // manual data emit karta hai Result Class ma

        }catch (e: Exception){
            Uistate.Failure(e.localizedMessage ?: "Unknown error during login")
        }
    }


}