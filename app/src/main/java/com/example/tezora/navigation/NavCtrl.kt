package com.example.tezora.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tezora.presentation.auth.AuthViewModel
import com.example.tezora.presentation.auth.view.Forget
import com.example.tezora.presentation.HomeScreen.HomeScreen
import com.example.tezora.presentation.auth.view.Login
import com.example.tezora.presentation.auth.view.SignUp
import com.example.tezora.presentation.auth.view.splash_screen
import androidx.compose.runtime.getValue
import com.example.tezora.presentation.HomeScreen.HomeProduct
import com.example.tezora.presentation.HomeScreen.Screenlist
import com.example.tezora.presentation.HomeScreen.SettingScreen
import com.example.tezora.presentation.HomeScreen.viewModel.ProductViewModel


@Composable
fun Navcontroler(
    authViewModel: AuthViewModel

    ) {

    val navController = rememberNavController()

    // session check
    val isLoggedIn by authViewModel.isLoggedin.collectAsState()

    // check user login or not
    val startDestination = if (isLoggedIn){
        Routes.Home
    }else{
        Routes.Splash // intro
    }

       //nav ctrl
    NavHost(navController = navController, startDestination = startDestination
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
            HomeScreen(authViewModel)
        }
        composable < Routes.HomeProduct>{
            HomeProduct(

            )
        }


    }

}