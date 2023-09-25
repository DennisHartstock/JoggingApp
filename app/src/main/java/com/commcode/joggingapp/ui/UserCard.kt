package com.commcode.joggingapp.ui

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.commcode.joggingapp.ui.theme.JoggingAppTheme

@Preview(name = "Light Mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")

@Composable
fun UserCard() {
    JoggingAppTheme {
        Card(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .padding(4.dp)
                .fillMaxWidth()
                .height(200.dp),
            border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.onBackground)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.primary)
                        .size(50.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Image", color = MaterialTheme.colorScheme.onPrimary)
                }
                UserStats("Name", "John")
                UserStats("Total Distance", "100 km")
                UserStats("Average Speed", "8 km/h")
            }
        }
    }
}

@Composable
private fun UserStats(
    title: String,
    value: String,
) {
    Column(
        modifier = Modifier
            .height(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.primary,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = value,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.ExtraBold
        )
    }
}