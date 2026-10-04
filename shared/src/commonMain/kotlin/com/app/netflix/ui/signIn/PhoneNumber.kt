package com.app.netflix.ui.signIn

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.app.netflix.ui.theme.NetflixTheme

@Composable
fun PhoneNumber(onLoginSuccess: () -> Unit, onBackClick: () -> Unit) {
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
            val (box, readyToWatchTitle, spacerOne, enterInfoTitle, spacerTwo,
                editTextEmailMobile, spacerThree, buttonContinue, spacerFour,
                textHelp, spacerFive, thisPageTitle) = createRefs()
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
                text = "Ready to watch?",
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
            Text(
                text = "Enter your information to sign in or get started with a new account",
                fontSize = 20.sp,
                lineHeight = 32.sp,
                modifier = Modifier.constrainAs(enterInfoTitle) {
                    top.linkTo(spacerOne.bottom)
                    start.linkTo(guideLineFromLeft)
                    end.linkTo(guideLineFromRight)
                    width = Dimension.fillToConstraints
                }
            )
            Spacer(modifier = Modifier
                .height(24.dp)
                .constrainAs(spacerTwo) {
                    top.linkTo(enterInfoTitle.bottom)
                    start.linkTo(guideLineFromLeft)
                })
            LoginFlowOutlinedTextField(
                hint = "Email or mobile number",
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(editTextEmailMobile) {
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
                    top.linkTo(editTextEmailMobile.bottom)
                    start.linkTo(guideLineFromLeft)
                })
            Button(
                onClick = onLoginSuccess,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(buttonContinue) {
                        top.linkTo(spacerThree.bottom)
                        start.linkTo(guideLineFromLeft)
                        end.linkTo(guideLineFromRight)
                        width = Dimension.fillToConstraints
                    }
            ) {
                Text(text = "Continue", fontSize = 20.sp, modifier = Modifier.padding(all = 8.dp))
            }
            Spacer(modifier = Modifier
                .height(40.dp)
                .constrainAs(spacerFour) {
                    top.linkTo(buttonContinue.bottom)
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
fun PhoneNumberPreview() {
    NetflixTheme {
        PhoneNumber({}, {})
    }
}