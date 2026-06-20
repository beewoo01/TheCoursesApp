package com.example.coursesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.coursesapp.R

@Composable
fun LatestLessonText(modifier: Modifier) {
    Text(
        text = "Latest Lessons",
        fontSize = 20.sp,
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun SeeAllText(modifier: Modifier) {
    Text(
        text = "See All",
        fontSize = 20.sp,
        color = Color.Blue,
        modifier = modifier
    )
}

@Composable
fun LessonCard(modifier: Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize(Alignment.TopStart)
                .fillMaxHeight()
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.width(8.dp))

            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (lessonsDate, timeImg, lessonSchedule, lessonsImg, lessonTitle, lessonDescription) = createRefs()

                Text(
                    text = "Lesson Date",
                    color = Color.Gray,
                    modifier = Modifier.constrainAs(lessonsDate) {
                        top.linkTo(parent.top, 15.dp)
                        start.linkTo(parent.start, 24.dp)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.outline_timer_24),
                    contentDescription = "time",
                    modifier = Modifier.constrainAs(timeImg) {
                        top.linkTo(lessonsDate.bottom, margin = 8.dp)
                        start.linkTo(lessonsDate.start)
                    }
                )

                Text(
                    text = "Thur Jun 6 | 8:00 - 8:30 AM",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.constrainAs(lessonSchedule) {
                        top.linkTo(timeImg.top)
                        start.linkTo(timeImg.end, 4.dp)

                    })

                Image(
                    painter = painterResource(R.drawable.outline_calendar_today_24),
                    contentDescription = "Data structure",
                    modifier = Modifier
                        .constrainAs(lessonsImg) {
                            top.linkTo(timeImg.bottom, margin = 16.dp)
                            start.linkTo(timeImg.start)
                            bottom.linkTo(parent.bottom, margin = 16.dp)
                        }
                        .size(60.dp)
                )

                Text(
                    text = "Data Structures & Algorithms",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.constrainAs(lessonTitle) {
                        top.linkTo(lessonsImg.top)
                        start.linkTo(lessonsImg.end, 12.dp)
                    }
                )

                Text(
                    text = "To be a pro developer, you need to master data structures and algorithms",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.constrainAs(lessonDescription) {
                        top.linkTo(lessonTitle.bottom, 2.dp)
                        start.linkTo(lessonTitle.start)
                    }.padding(end = 4.dp)
                )
            }
        }

    }
}