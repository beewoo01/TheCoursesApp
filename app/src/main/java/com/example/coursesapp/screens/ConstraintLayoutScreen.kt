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
        val (
            gradientBackground,
            profileImg,
            notificationImg,
            welcomeText,
            questionText,
            joinBtn,
            coursesImg,
            card
        ) = createRefs()

        val horizontalGuideline1 = createGuidelineFromBottom(0.45f)

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

        // 2- Header: (chain example)
        val topGuidLine = createGuidelineFromTop(24.dp)
        val startGuidLine = createGuidelineFromStart(16.dp)
        val endGuidLine = createGuidelineFromEnd(16.dp)

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


        /// 3- The Middle Part
        WelcomeText(modifier = Modifier.constrainAs(welcomeText) {
            top.linkTo(profileImg.bottom, margin = 24.dp)
            start.linkTo(startGuidLine)
        })

        QuestionText(modifier = Modifier.constrainAs(questionText) {
            top.linkTo(welcomeText.bottom, margin = 0.dp)
            start.linkTo(welcomeText.start)
        })

        JoinNowButton(
            modifier = Modifier.constrainAs(joinBtn) {
                top.linkTo(questionText.bottom, margin = 32.dp)
                start.linkTo(questionText.start)
                end.linkTo(questionText.end)
            }) {

        }

        CoursesImage(
            modifier = Modifier.constrainAs(coursesImg) {
                bottom.linkTo(horizontalGuideline1, margin = 0.dp)
                end.linkTo(endGuidLine)
                top.linkTo(joinBtn.bottom, margin = 0.dp)

                width = Dimension.value(240.dp)
                height = Dimension.fillToConstraints
            }
        )

        MyCard(
            modifier = Modifier.constrainAs(card) {
                top.linkTo(horizontalGuideline1, margin = (-32).dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints

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