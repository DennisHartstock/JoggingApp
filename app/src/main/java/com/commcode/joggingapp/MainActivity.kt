package com.commcode.joggingapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.commcode.joggingapp.ui.theme.JoggingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JoggingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Jogging()
                }
            }
        }
    }
}

@Composable
fun Jogging() {
    var duration = 1
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Jogging for", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            OutlinedButton(onClick = {
                if (duration > 1) {
                    duration--
                }
            }) {
                Text(
                    text = "-",
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            Text(
                text = "$duration",
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.headlineLarge
            )
            OutlinedButton(onClick = {
                duration++
            }) {
                Text(
                    text = "+",
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "minutes", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { }) {
            Text(text = "Start", style = MaterialTheme.typography.headlineLarge)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")

@Preview(showBackground = true)
@Composable
fun JoggingPreview() {
    JoggingAppTheme {
        Surface {
            Jogging()
        }
    }
}