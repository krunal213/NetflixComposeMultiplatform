package com.app.netflix.ui.signIn

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.app.netflix.ui.theme.NetflixTheme

@Composable
fun Password(onChangeClick: () -> Unit, onBackClick: () -> Unit, onSignInClick: () -> Unit) {
    Scaffold(
        topBar = {
            LoginFlowTopAppBar(onBackClick = onBackClick)
        }
    ) { innerPadding ->
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val guideLineFromTop = createGuidelineFromTop(16.dp)
            val guideLineFromLeft = createGuidelineFromAbsoluteLeft(16.dp)
            val guideLineFromRight = createGuidelineFromAbsoluteRight(16.dp)
            val (
                box, readyToWatchTitle, spacerOne, mobileNumber, spacerTwo,
                editTextPassword, spacerThree, buttonSignIn, spacerFour,
                textHelp, spacerFive, thisPageTitle, spacerSix, buttonUseSignInCode,
                spacerSeven, textOr
            ) = createRefs()
            LoginFlowGradientLayout(
                modifier = Modifier
                    .constrainAs(box) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.percent(1.5f)
                    }
            )
            LoginFlowHeaderLayout(
                text = "Enter your password",
                modifier = Modifier
                    .padding(innerPadding)
                    .constrainAs(readyToWatchTitle) {
                        top.linkTo(guideLineFromTop)
                        start.linkTo(guideLineFromLeft)
                    }
            )
            Spacer(modifier = Modifier
                .height(16.dp)
                .constrainAs(spacerOne) {
                    top.linkTo(readyToWatchTitle.bottom)
                    start.linkTo(parent.start)
                })
            TextField(
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(mobileNumber) {
                        top.linkTo(spacerOne.bottom)
                        start.linkTo(guideLineFromLeft)
                        end.linkTo(guideLineFromRight)
                        width = Dimension.fillToConstraints
                    },
                value = "8806616913",
                onValueChange = {},
                trailingIcon = {
                    TextButton(onClick = onChangeClick) {
                        Text("Change", fontSize = 16.sp)
                    }
                }
            )
            Spacer(modifier = Modifier
                .height(24.dp)
                .constrainAs(spacerTwo) {
                    top.linkTo(mobileNumber.bottom)
                    start.linkTo(guideLineFromLeft)
                })
            LoginFlowOutlinedTextField(
                hint = "Password",
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(editTextPassword) {
                        top.linkTo(spacerTwo.bottom)
                        start.linkTo(guideLineFromLeft)
                        end.linkTo(guideLineFromRight)
                        width = Dimension.fillToConstraints
                    },
                value = "",
                onValueChange = {}
            )
            Spacer(modifier = Modifier
                .height(12.dp)
                .constrainAs(spacerThree) {
                    top.linkTo(editTextPassword.bottom)
                    start.linkTo(guideLineFromLeft)
                })
            Button(
                onClick = onSignInClick,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(buttonSignIn) {
                        top.linkTo(spacerThree.bottom)
                        start.linkTo(guideLineFromLeft)
                        end.linkTo(guideLineFromRight)
                        width = Dimension.fillToConstraints
                    }
            ) {
                Text(text = "Sign In", fontSize = 20.sp, modifier = Modifier.padding(all = 8.dp))
            }
            Spacer(modifier = Modifier
                .height(12.dp)
                .constrainAs(spacerSix) {
                    top.linkTo(buttonSignIn.bottom)
                    start.linkTo(guideLineFromLeft)
                })
            Text("Or", textAlign = TextAlign.Center, modifier = Modifier
                .fillMaxWidth()
                .constrainAs(textOr) {
                    top.linkTo(spacerSix.bottom)
                    start.linkTo(guideLineFromLeft)
                    end.linkTo(guideLineFromRight)
                    width = Dimension.fillToConstraints
                })
            Spacer(modifier = Modifier
                .height(12.dp)
                .constrainAs(spacerSeven) {
                    top.linkTo(textOr.bottom)
                    start.linkTo(guideLineFromLeft)
                })
            Button(
                onClick = {},
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(buttonUseSignInCode) {
                        top.linkTo(spacerSeven.bottom)
                        start.linkTo(guideLineFromLeft)
                        end.linkTo(guideLineFromRight)
                        width = Dimension.fillToConstraints
                    }
            ) {
                Text(
                    text = "Use sign-in code",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(all = 8.dp)
                )
            }
            Spacer(modifier = Modifier
                .height(40.dp)
                .constrainAs(spacerFour) {
                    top.linkTo(buttonUseSignInCode.bottom)
                    start.linkTo(parent.start)
                })
            Text(
                text = "Get Help",
                fontSize = 24.sp,
                modifier = Modifier.constrainAs(textHelp) {
                    top.linkTo(spacerFour.bottom)
                    start.linkTo(guideLineFromLeft)
                })
            Spacer(modifier = Modifier
                .height(40.dp)
                .constrainAs(spacerFive) {
                    top.linkTo(textHelp.bottom)
                    start.linkTo(parent.start)
                })
            SecurityNotice(
                modifier = Modifier.constrainAs(thisPageTitle) {
                    top.linkTo(spacerFive.bottom)
                    start.linkTo(guideLineFromLeft)
                    end.linkTo(guideLineFromRight)
                    width = Dimension.fillToConstraints
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PasswordPreview() {
    NetflixTheme {
        Password(onBackClick = {}, onChangeClick = {}, onSignInClick = {})
    }
}