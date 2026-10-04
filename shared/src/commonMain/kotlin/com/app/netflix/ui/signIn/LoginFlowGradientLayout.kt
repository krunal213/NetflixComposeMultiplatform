package com.app.netflix.ui.signIn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun LoginFlowGradientLayout(modifier: Modifier){
    Box(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF441518),
                        Color.Black,
                        Color.Black,
                        Color.Black
                    )
                )
            )
    )
}