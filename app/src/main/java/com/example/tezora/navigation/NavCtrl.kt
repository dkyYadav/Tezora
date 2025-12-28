package com.example.tezora.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tezora.presentation.auth.AuthViewModel
import com.example.tezora.presentation.auth.view.Forget
import com.example.tezora.presentation.auth.view.Home
import com.example.tezora.presentation.auth.view.Login
import com.example.tezora.presentation.auth.view.SignUp
import com.example.tezora.presentation.auth.view.splash_screen


@Composable
fun Navcontroler(
    authViewModel: AuthViewModel
) {

    val navController = rememberNavController()

       //nav ctrl
    NavHost(navController = navController, startDestination = Routes.Splash
    ) {
        // nav Graph

        composable <Routes.Splash>{
            splash_screen(navController)
        }
        composable<Routes.Login> {
            Login(navController,
                authViewModel)
        }
        composable <Routes.Signup>{
            SignUp(
                navController,
                authViewModel
            )
        }
        composable <Routes.Forget>{
            Forget(navController)
        }
        composable <Routes.Home>{
            Home()
        }

    }

}