package com.commcode.joggingapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun StartScreen(onStartClicked: () -> Unit, jogging: MutableState<Int>) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Jogging for",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row {
            FilledTonalButton(onClick = {
                if (jogging.value > 5) {
                    jogging.value--
                }
            }, shape = MaterialTheme.shapes.large) {
                Text(
                    text = "-",
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            Text(
                text = "${jogging.value}",
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp),
                style = MaterialTheme.typography.headlineLarge
            )
            FilledTonalButton(onClick = {
                if (jogging.value < 60) {
                    jogging.value++
                }
            }, shape = MaterialTheme.shapes.large) {
                Text(
                    text = "+",
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "minutes",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onStartClicked) {
            Text(text = "Start", style = MaterialTheme.typography.headlineLarge)
        }
    }
}