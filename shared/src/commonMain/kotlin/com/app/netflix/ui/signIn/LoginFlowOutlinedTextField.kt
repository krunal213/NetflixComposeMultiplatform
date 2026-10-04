package com.app.netflix.ui.signIn

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.app.netflix.ui.theme.NetflixTheme

@Composable
fun LoginFlowOutlinedTextField(
    hint: String,
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        label = { Text(text = hint) },
        value = value,
        onValueChange = onValueChange,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.White,
            focusedLabelColor = Color.White,
            cursorColor = Color.White
        )
    )
}

@Preview(showBackground = true)
@Composable
fun LoginFlowOutlinedTextFieldPreview() {
    NetflixTheme {
        LoginFlowOutlinedTextField("Hello",Modifier,"value",{})
    }
}