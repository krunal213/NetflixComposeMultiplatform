package com.app.netflix

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.netflix.ui.getStarted.GetStarted
import com.app.netflix.ui.splash.Splash
import com.app.netflix.ui.theme.NetflixTheme

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    NetflixTheme {
        NavHost(navController = navController, startDestination = "splash") {
            composable("splash") {
                Splash {
                    navController.navigate("getStarted") {
                        popUpTo("splash") {
                            inclusive = true
                        }
                    }
                }
            }
            composable("getStarted") {
                GetStarted {
                    //navController.navigate("phoneNumber")
                }
            }
        }
    }

}

