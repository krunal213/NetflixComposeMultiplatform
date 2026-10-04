package com.app.netflix

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.netflix.ui.chooseProfile.ChooseProfile
import com.app.netflix.ui.dashboard.Dashboard
import com.app.netflix.ui.getStarted.GetStarted
import com.app.netflix.ui.howProfileWorks.HowProfileWorks
import com.app.netflix.ui.signIn.Password
import com.app.netflix.ui.signIn.PhoneNumber
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
                    navController.navigate("phoneNumber")
                }
            }
            composable("phoneNumber") {
                PhoneNumber(onLoginSuccess = {
                    navController.navigate("password")
                }, onBackClick = {
                    navController.navigateUp()
                })
            }
            composable("password") {
                Password(onChangeClick = {
                    navController.navigateUp()
                }, onBackClick = {
                    navController.navigateUp()
                }, onSignInClick = {
                    navController.navigate("howProfileWorks")
                })
            }
            composable("howProfileWorks") {
                HowProfileWorks {
                    navController.navigate("chooseProfile")
                }
            }
            composable("chooseProfile") {
                ChooseProfile {
                    navController.navigate("dashboard")
                }
            }
            composable("dashboard") {
                Dashboard()
            }
        }
    }
}

