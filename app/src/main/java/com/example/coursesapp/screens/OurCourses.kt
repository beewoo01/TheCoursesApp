package com.example.coursesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coursesapp.R

@Composable
fun TextOurCoursed(modifier: Modifier) {
    Text(
        text = "New Courses",
        modifier = modifier,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black
    )

}

@Composable
fun AndroidCourseImg(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.androidic),
        contentDescription = "Android Courses",
        modifier = modifier.size(70.dp)
    )
}

@Composable
fun JavaCourseImg(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.javaic),
        contentDescription = "Java Course",
        modifier = modifier.size(70.dp)
    )
}

@Composable
fun PythonCourseImg(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.pythonic),
        contentDescription = "Python Course",
        modifier = modifier.size(70.dp)
    )
}
