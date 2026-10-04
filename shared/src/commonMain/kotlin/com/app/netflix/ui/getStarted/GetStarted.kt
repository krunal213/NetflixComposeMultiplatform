package com.app.netflix.ui.getStarted

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import netflixclone.shared.generated.resources.Res
import netflixclone.shared.generated.resources.compose_multiplatform
import netflixclone.shared.generated.resources.ic_netflix_banner
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetStarted(onGetStartedClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ),
                title = {
                    //Text("Netflix")
                }
            )
        }
    ) { innerPadding ->
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val (horizontalPager, button) = createRefs()
            val pagerState = rememberPagerState(pageCount = { 4 })
            HorizontalPager(
                pagerState, modifier = Modifier
                    .constrainAs(horizontalPager) {
                        top.linkTo(parent.top)
                        bottom.linkTo(button.top, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }, pageSpacing = 32.dp, contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp))
                        .border(
                            3.dp,
                            Color.DarkGray.copy(alpha = 0.6f),
                            RoundedCornerShape(16.dp)
                        )
                ) {
                    val (textCancel, textUnlimited) = createRefs()
                    Image(
                        painter = painterResource(Res.drawable.ic_netflix_banner),
                        contentDescription = "Hello",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.Transparent,
                                        Color.Transparent,
                                        Color.Transparent,
                                        Color.Black,
                                        Color.DarkGray
                                    )
                                )
                            )
                    )
                    Text(
                        "Unlimited movies, shows & more",
                        modifier = Modifier.constrainAs(textUnlimited) {
                            bottom.linkTo(textCancel.top, margin = 24.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                        color = Color.White,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 40.sp
                    )
                    Text(
                        "Starts at $149. Cancel anytime.",
                        modifier = Modifier.constrainAs(textCancel) {
                            bottom.linkTo(parent.bottom, margin = 36.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                        color = Color.LightGray,
                        fontSize = 20.sp
                    )
                }

            }
            Button(
                onClick = onGetStartedClick,
                modifier = Modifier
                    .padding(all = 16.dp)
                    .constrainAs(button) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                shape = RoundedCornerShape(4.dp),
            ) {
                Text("Get Started", modifier = Modifier.padding(all = 8.dp), fontSize = 20.sp)
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GetStartedPreview() {
    GetStarted {}
}