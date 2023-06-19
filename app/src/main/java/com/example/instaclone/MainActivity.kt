package com.example.instaclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instaclone.presentation.Authentication.AuthenticationViewModel
import com.example.instaclone.presentation.Authentication.LoginScreen
import com.example.instaclone.presentation.Authentication.SignUpScreen
import com.example.instaclone.presentation.SplashScreen
import com.example.instaclone.ui.theme.InstacloneTheme
import com.example.instaclone.util.Screens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstacloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val authViewModel: AuthenticationViewModel = hiltViewModel()
                    InstagramCloneApp(
                        navController = navController,
                        authViewModel = authViewModel
                    )
                }
            }
        }
    }
}


@Composable
fun InstagramCloneApp(navController: NavHostController, authViewModel: AuthenticationViewModel) {
    NavHost(
        navController = navController, startDestination = Screens.SplashScreen.route,
    ) {
        composable(route = Screens.LoginScreen.route) {
            LoginScreen()
        }
        composable(route = Screens.SignUpScreen.route) {
            SignUpScreen()
        }
        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navController = navController, authViewModel = authViewModel)
        }
        composable(route = Screens.FeedsScreen.route) {
            SplashScreen(navController = navController, authViewModel = authViewModel)
        }

    }
}