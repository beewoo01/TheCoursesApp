package com.example.coursesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coursesapp.R


@Composable
fun ProfileImage(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.profile),
        contentDescription = "Profile",
        modifier = modifier
            .padding(start = 16.dp)
            .clip(CircleShape)
            .size(42.dp)
    )
}

@Composable
fun NotificationImg(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.outline_eco_24),
        contentDescription = "",
        modifier = modifier
            .padding(end = 16.dp)
            .clip(CircleShape)
            .size(42.dp),
    )
}