package com.app.netflix

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.netflix.ui.splash.Splash
import com.app.netflix.ui.theme.NetflixTheme
import org.jetbrains.compose.resources.painterResource

import netflixclone.shared.generated.resources.Res
import netflixclone.shared.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    NetflixTheme {
        Splash{}
    }
}

