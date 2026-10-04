package com.app.netflix.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color.Red,
    onPrimary = Color.White,
    primaryContainer = Color.Transparent
    /*secondary = PurpleGrey80,
    tertiary = Pink80,
    surface = Color.Black,
    onSurface = Color.White*/
)

@Composable
fun NetflixTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
    ){
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            content()
        }
    }
}