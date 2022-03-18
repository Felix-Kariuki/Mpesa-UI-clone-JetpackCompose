package com.flexcode.mpesauiclone

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.flexcode.mpesauiclone.ui.*

@Composable
fun SetUpNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route
        //if it fails include splash screen
    ){
        composable(
            route = Screen.Splash.route
        ){
            SplashScreen(navController = navHostController)
        }
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navHostController)
        }
        composable(
            route = Screen.Grow.route
        ){
            GrowScreen(navController = navHostController)
        }
        composable(
            route = Screen.Discover.route
        ){
            DiscoverScreen(navController = navHostController)
        }
        composable(
            route = Screen.Transaction.route
        ){
            TransactionScreen(navController = navHostController)
        }

    }

}