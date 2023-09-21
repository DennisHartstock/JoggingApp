package com.commcode.joggingapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun UserCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.White)
                .size(50.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Image")
        }
        TwoBoxes()
        TwoBoxes()
        TwoBoxes()
    }
}

@Composable
private fun TwoBoxes() {
    Column(
        modifier = Modifier
            .height(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.Red)
                .height(30.dp)
        ) {
            Text(text = "Box1")
        }
        Box(
            modifier = Modifier
                .background(color = Color.Green)
                .height(30.dp)
        ) {
            Text(text = "Box2")
        }
    }
}