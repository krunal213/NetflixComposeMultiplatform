package com.app.netflix.ui.signIn

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun SecurityNotice(modifier: Modifier){
    Text(
        text = "This page is protected by Google reCAPTCHA to ensure you're not a bot.",
        lineHeight = 24.sp,
        modifier = modifier
    )
}