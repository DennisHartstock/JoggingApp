package com.commcode.joggingapp

import android.content.res.Configuration
import android.os.Bundle
import android.os.CountDownTimer
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
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
                MainScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var shouldShowExerciseScreen by remember { mutableStateOf(true) }

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        if (shouldShowExerciseScreen) {
            StartScreen(
                onStartClicked = { shouldShowExerciseScreen = false },
                joggingUnit = JoggingUnit(duration = 1),
            )
        } else {
            ExerciseScreen(modifier = modifier, joggingUnit = JoggingUnit(duration = 1))
        }
    }
}

@Composable
fun ExerciseScreen(modifier: Modifier = Modifier, joggingUnit: JoggingUnit) {

    val duration: Int by rememberSaveable { mutableStateOf(joggingUnit.duration) }

    val durationInMillis: Int = duration * 60 * 1000

    val countDown = remember {
        mutableStateOf(durationInMillis)
    }

    val countDownTimer =
        object : CountDownTimer(durationInMillis.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countDown.value = millisUntilFinished.toInt()
            }

            override fun onFinish() {

            }
        }

    DisposableEffect(key1 = "key") {
        countDownTimer.start()
        onDispose {
            countDownTimer.cancel()
        }
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Jogging for", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(24.dp))

//        var countDownTimer by remember { mutableStateOf(duration * 60) }
//        LaunchedEffect(key1 = countDownTimer) {
//            if (countDownTimer > 0) {
//                delay(1000)
//                countDownTimer--
//            }
//        }

        Text(
            text = "${countDown.value / 1000}",
//            text = "$countDownTimer",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
fun StartScreen(onStartClicked: () -> Unit, joggingUnit: JoggingUnit) {

    var duration: Int by remember { mutableStateOf(joggingUnit.duration) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Jogging for", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(24.dp))
        Row {
            FilledTonalButton(onClick = {
                if (duration > 1) {
                    duration--
                }
            }, shape = MaterialTheme.shapes.large) {
                Text(
                    text = "-",
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            Text(
                text = "$duration",
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp),
                style = MaterialTheme.typography.headlineLarge
            )
            FilledTonalButton(onClick = {
                if (duration < 60) {
                    duration++
                }
            }, shape = MaterialTheme.shapes.large) {
                Text(
                    text = "+",
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "minutes", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onStartClicked) {
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
            StartScreen(onStartClicked = {}, joggingUnit = JoggingUnit())
        }
    }
}