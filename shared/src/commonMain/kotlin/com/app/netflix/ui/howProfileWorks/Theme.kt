package com.app.netflix.ui.howProfileWorks

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    onPrimary = Color.Black,
    background = Color.Black,
    surface = Color.Black
)

@Composable
fun HowProfileWorksTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = DarkColorScheme) {
        Surface(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}