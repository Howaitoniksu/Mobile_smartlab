package com.example.smartlab.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartlab.screens.Catalog
import com.example.smartlab.screens.EmailCode
import com.example.smartlab.screens.LogIn
import com.example.smartlab.screens.PreLogIn
import com.example.smartlab.screens.PreLogInSecond
import com.example.smartlab.screens.PreLogInThird
import com.example.smartlab.screens.SplashScreen
import com.example.smartlab.viewmodel.ViewModelMain


@Composable
fun Navigation(ViewModel: ViewModelMain) {
    val navController = rememberNavController()
    NavHost(navController = navController,

        startDestination = "splashScreen")
    {
        composable("splashScreen"){
            SplashScreen(navController)
        }
        composable("PreLogIn"){
            PreLogIn(navController)
        }
        composable("PreLogInSecond"){
            PreLogInSecond(navController)
        }
        composable("logInScreen"){
            LogIn(navController, ViewModel)
        }
        composable("PreLogInThird")
        {
            PreLogInThird(navController)
        }
        composable("EmailCode"){
            EmailCode(navController, ViewModel)
        }
        composable("Catalog"){
            Catalog(navController, ViewModel)
        }
    }
}