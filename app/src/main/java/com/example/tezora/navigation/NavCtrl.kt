package com.example.tezora.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tezora.presentation.auth.view.Forget
import com.example.tezora.presentation.auth.view.Home
import com.example.tezora.presentation.auth.view.Login
import com.example.tezora.presentation.auth.view.SignUp
import com.example.tezora.presentation.auth.view.splash_screen


@Composable
fun Navcontroler() {

    val navController = rememberNavController()

       //nav ctrl
    NavHost(navController = navController, startDestination = Routes.Login
    ) {
        // nav Graph

        composable <Routes.Splash>{
            splash_screen()
        }
        composable<Routes.Login> {
            Login(navController)
        }
        composable <Routes.Signup>{
            SignUp(navController)
        }
        composable <Routes.Forget>{
            Forget(navController)
        }
        composable <Routes.Home>{
            Home()
        }

    }

}