package com.app.netflix.ui.signIn

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun LoginFlowHeaderLayout(text: String, modifier: Modifier) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
}