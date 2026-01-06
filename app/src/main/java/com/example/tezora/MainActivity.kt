package com.example.tezora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tezora.data.remote.RetrofitClient
import com.example.tezora.data.repository.AuthRepositoryImpl
import com.example.tezora.data.repository.ProductRepositoryImpl
import com.example.tezora.domain.Usecase.GetProductUseCase
import com.example.tezora.domain.Usecase.LoginUseCase
import com.example.tezora.domain.Usecase.signupusecase
import com.example.tezora.domain.repository.AuthRepository
import com.example.tezora.navigation.Navcontroler
import com.example.tezora.presentation.HomeScreen.viewModel.AppViewModels
import com.example.tezora.presentation.HomeScreen.viewModel.ProductViewModel
import com.example.tezora.presentation.auth.AuthViewModel
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // manual Dependency Injection
        val firebaseAuth = FirebaseAuth.getInstance()
        val authRepository : AuthRepository = AuthRepositoryImpl(firebaseAuth)
        val signupusecase = signupusecase(authRepository)
        val loginUseCase = LoginUseCase(authRepository)
        val authViewModel = AuthViewModel(signupusecase,loginUseCase)

        val api = RetrofitClient.api
        val repository = ProductRepositoryImpl(api)
        val useCase = GetProductUseCase(repository)
        AppViewModels.productViewModel  =  ProductViewModel(useCase)

        setContent {
            Navcontroler(
                authViewModel = authViewModel
            )

        }

    }
}

