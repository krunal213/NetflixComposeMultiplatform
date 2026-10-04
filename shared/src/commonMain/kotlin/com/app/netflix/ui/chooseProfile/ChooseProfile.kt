package com.app.netflix.ui.chooseProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.netflix.ui.theme.NetflixTheme
import netflixclone.shared.generated.resources.Res
import netflixclone.shared.generated.resources.doomsday
import netflixclone.shared.generated.resources.netflix
import org.jetbrains.compose.resources.painterResource

@Composable
fun ChooseProfile(onProfileClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(Res.drawable.doomsday),
            "",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(6) {
                ChooseProfileItem(onProfileClick = onProfileClick)
            }
        }
    }
}

@Composable
private fun ChooseProfileItem(onProfileClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable(onClick = onProfileClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.netflix),
            "",
            modifier = Modifier
                .weight(1.0f)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Profile Name", color = Color.White)
    }
}

@Composable
@Preview(showBackground = true)
private fun ChooseProfileItemPreview() {
    ChooseProfileItem({})
}

@Composable
@Preview(showBackground = true)
private fun ChooseProfilePreview() {
    NetflixTheme {
        ChooseProfile({})
    }
}