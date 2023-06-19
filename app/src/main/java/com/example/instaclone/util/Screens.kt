package com.example.instaclone.util

sealed class Screens(val route: String) {
    object SplashScreen: Screens("splash_screen")
    object LoginScreen: Screens("login_screen")
    object SignUpScreen: Screens("signup_screen")
    object FeedsScreen: Screens("feeds_screen")
}
