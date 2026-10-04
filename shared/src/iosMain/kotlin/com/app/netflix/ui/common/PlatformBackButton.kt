package com.app.netflix.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
actual fun PlatformBackButton(
    onBackClick: () -> Unit
) {
    IconButton(
        onClick = onBackClick
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
            contentDescription = "Back"
        )
    }
}