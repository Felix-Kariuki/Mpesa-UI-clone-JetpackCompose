package com.flexcode.mpesauiclone

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.flexcode.mpesauiclone.ui.HomeScreen
import com.flexcode.mpesauiclone.ui.SplashScreen
import com.flexcode.mpesauiclone.ui.theme.MpesaUiCloneTheme
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Navigation()
            MpesaUiCloneTheme {
//                HomeScreen()
                navController = rememberNavController()
                SetUpNavHost(navHostController = navController)
            }

        }
    }
}

/*@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("main_screen") {
            Box(modifier = Modifier.fillMaxSize()) {
                HomeScreen(navController = rememberNavController())
            }
        }
    }
}*/


