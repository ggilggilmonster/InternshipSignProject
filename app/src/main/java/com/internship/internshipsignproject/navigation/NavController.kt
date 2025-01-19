package com.internship.internshipsignproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.internship.internshipsignproject.screen.HomeScreen
import com.internship.internshipsignproject.screen.SignInScreen
import com.internship.internshipsignproject.screen.SignUpScreen

@Composable
fun NavController(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        composable(NavRoute.Home.name) {
            HomeScreen(
                navigateToSignIn = { navController.navigate(NavRoute.SignIn.name) },
                navigateToSignUp = { navController.navigate(NavRoute.SignUp.name) }
            )
        }

        composable(NavRoute.SignIn.name) {
            SignInScreen(
                navigateToHome = { navController.navigate(NavRoute.Home.name) }
            )
        }

        composable(NavRoute.SignUp.name) {
            SignUpScreen(
                navigateToSignIn = { navController.navigate(NavRoute.SignIn.name) },
                navigateToHome = { navController.popBackStack() }
            )
        }
    }
}