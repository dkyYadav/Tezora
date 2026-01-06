package com.example.tezora.navigation

import kotlinx.serialization.Serializable



@Serializable
sealed class Routes {

    @Serializable
    object  Splash: Routes()

    @Serializable
    object  Login: Routes()

    @Serializable
    object  Signup: Routes()

    @Serializable
    object  Forget: Routes()

    @Serializable
    object  Home: Routes()

    @Serializable
    object HomeProduct: Routes()

    @Serializable
    object Screenlist: Routes()

}