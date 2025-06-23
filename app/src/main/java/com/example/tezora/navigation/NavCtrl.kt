package com.example.tezora.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tezora.view.Forget
import com.example.tezora.view.Home
import com.example.tezora.view.Login
import com.example.tezora.view.SignUp
import com.example.tezora.view.splash_screen


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
            Forget()
        }
        composable <Routes.Home>{
            Home()
        }

    }

}