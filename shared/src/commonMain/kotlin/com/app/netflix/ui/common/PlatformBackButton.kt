package com.app.netflix.ui.common

import androidx.compose.runtime.Composable

@Composable
expect fun PlatformBackButton(
    onBackClick: () -> Unit
)