package com.app.netflix.ui.dashboard

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.WebStories
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.netflix.ui.theme.NetflixTheme

@Composable
fun Dashboard() {
    var index by remember { mutableStateOf(0) }
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        NavigationBar(
            modifier = Modifier.padding(16.dp).clip(CircleShape),
            windowInsets = WindowInsets(0, 0, 0, 0)
        ) {
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Home,
                        contentDescription = "Home"
                    )
                },
                label = { Text("Home") },
                selected = index == 0,
                onClick = {
                    index = 0
                    navController.navigate("home")
                }
            )
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.WebStories,
                        contentDescription = "Clips"
                    )
                },
                label = { Text("Clips") },
                selected = index == 1,
                onClick = {
                    index = 1
                    navController.navigate("clips")
                }
            )
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search"
                    )
                },
                label = { Text("Search") },
                selected = index == 2,
                onClick = {
                    index = 2
                    navController.navigate("search")
                }
            )
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Search"
                    )
                },
                label = { Text("My Netflix") },
                selected = index == 3,
                onClick = {
                    index = 3
                    navController.navigate("mynetflix")
                }
            )
        }
    }) {
        NavHost(
            navController = navController,
            startDestination = "home",
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }) {
            composable("home") {
                ConstraintLayout(modifier = Modifier.background(Color.Red).fillMaxSize()) {}
            }
            composable("clips") {
                ConstraintLayout(modifier = Modifier.background(Color.Green).fillMaxSize()) {

                }
            }
            composable("search") {
                ConstraintLayout(modifier = Modifier.background(Color.Blue).fillMaxSize()) {}
            }
            composable("mynetflix") {
                ConstraintLayout(modifier = Modifier.background(Color.Yellow).fillMaxSize()) {}
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    NetflixTheme {
        Dashboard()
    }
}