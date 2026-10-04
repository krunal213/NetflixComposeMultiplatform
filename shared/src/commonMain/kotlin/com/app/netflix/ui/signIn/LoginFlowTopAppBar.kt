package com.app.netflix.ui.signIn

import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import netflixclone.shared.generated.resources.Res
import netflixclone.shared.generated.resources.ic_netflix
import org.jetbrains.compose.resources.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.graphics.Color
import com.app.netflix.ui.common.PlatformBackButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginFlowTopAppBar(onBackClick: () -> Unit){
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        title = {
            Icon(
                painter = painterResource(Res.drawable.ic_netflix),
                contentDescription = "",
                modifier = Modifier.width(96.dp),
                tint = Color.Unspecified
            )
        },
        navigationIcon = {
            PlatformBackButton(
                onBackClick = onBackClick
            )
        }
    )
}
