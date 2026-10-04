package com.app.netflix.ui.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.netflix.ui.theme.NetflixTheme
import io.github.alexzhirkevich.compottie.ExperimentalCompottieApi
import io.github.alexzhirkevich.compottie.Lottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.Resource
import io.github.alexzhirkevich.compottie.rememberLottieAnimatable
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import kotlinx.coroutines.delay
import netflixclone.shared.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class, ExperimentalCompottieApi::class)
@Composable
fun Splash(onNavigate: () -> Unit) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.Resource(Res.getUri("files/animation_splash.json"))
    )
    val lottieAnimatable = rememberLottieAnimatable()
    var isProgressBarVisible by remember { mutableStateOf(false) }
    val currentOnNavigate by rememberUpdatedState(onNavigate)
    LaunchedEffect(composition) {
        if(composition!=null){
            lottieAnimatable.animate(
                composition
            )
            isProgressBarVisible = true
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Lottie(
            painter = rememberLottiePainter(
                composition,
            ),
            contentDescription = "",
            modifier = Modifier.height(200.dp).width(260.dp)
        )
        if (isProgressBarVisible) {
            SplashProgressBar(currentOnNavigate)
        }
    }
}

@Composable
private fun SplashProgressBar(currentOnNavigate: () -> Unit) {
    CircularProgressIndicator(
        modifier = Modifier.requiredSize(48.dp),
        strokeWidth = 5.dp,
    )
    LaunchedEffect(Unit) {
        delay(3000)
        currentOnNavigate()
    }
}

@Preview(showBackground = true)
@Composable
fun SplashProgressBarPreview() {
    NetflixTheme {
        SplashProgressBar {}
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    NetflixTheme {
        Splash {}
    }
}