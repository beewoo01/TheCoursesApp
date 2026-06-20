package com.example.coursesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.coursesapp.R

@Composable
fun ConstraintLayoutScreen() {
    ConstraintLayout(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        // 1- Creating the References for Composables
        // that will be constrainted within the layout
        val (gradientBackground, profileImg, notificationImg) = createRefs()

        val horizontalGuideline1 = createGuidelineFromTop(0.45f)

        BackgroundGradient(
            modifier = Modifier.constrainAs(gradientBackground) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                bottom.linkTo(horizontalGuideline1)

                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        )

        val topGuidLine = createGuidelineFromTop(16.dp)
        val startGuidLine = createGuidelineFromTop(16.dp)
        val endGuidLine = createGuidelineFromTop(16.dp)

        createHorizontalChain(
            profileImg, notificationImg, chainStyle = ChainStyle.SpreadInside
        )

        ProfileImage(modifier = Modifier.constrainAs(profileImg) {
            top.linkTo(topGuidLine)
        })

        NotificationImg(
            modifier = Modifier.constrainAs(notificationImg) {
                top.linkTo(profileImg.top)
                bottom.linkTo(profileImg.bottom)
            }
        )

    }
}

@Composable
fun BackgroundGradient(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.gradient_background),
        contentDescription = "Main Background",
        contentScale = ContentScale.FillBounds,
        modifier = modifier.alpha(0.8f)
    )
}