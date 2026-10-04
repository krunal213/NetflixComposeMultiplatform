package com.app.netflix.ui.howProfileWorks

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import netflixclone.shared.generated.resources.Res
import netflixclone.shared.generated.resources.ic_how_to_works
import netflixclone.shared.generated.resources.ic_netflix
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HowProfileWorks(onGotItClick : () -> Unit) {
    HowProfileWorksTheme {
        Scaffold(topBar = {
            CenterAlignedTopAppBar(title = {
                Icon(
                    painter = painterResource(Res.drawable.ic_netflix),
                    contentDescription = "",
                    modifier = Modifier.width(96.dp),
                    tint = Color.Unspecified
                )
            })
        }) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(all = 16.dp)
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_how_to_works),
                    "",
                    modifier = Modifier
                        .weight(1.0f)
                        .fillMaxSize()
                )
                Text(
                    text = "HOW DO THE PROFILE WORK",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Every account comes with 5 profiles for anyone that lives with you",
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 40.sp,
                    modifier = Modifier.padding(bottom = 80.dp, top = 16.dp)
                )
                Button(modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                    shape = RoundedCornerShape(4.dp), onClick = onGotItClick) {
                    Text("Got it", modifier = Modifier.padding(all = 8.dp), fontSize = 20.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HowProfileWorksPreview() {
    HowProfileWorksTheme {
        HowProfileWorks{}
    }
}