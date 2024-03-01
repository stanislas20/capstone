package com.stan.littlelemon


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Onboarding.route){
        composable(Home.route){
            Home(navController)
        }

        composable(Profile.route){
            Profile(navController)
        }

        composable(Onboarding.route){
            Onboarding( navController)
        }
    }

}


