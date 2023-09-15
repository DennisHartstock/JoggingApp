package com.commcode.joggingapp.screen

import android.os.CountDownTimer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ExerciseScreen(
    modifier: Modifier = Modifier,
    walking: MutableState<Int>,
    jogging: MutableState<Int>,
    pause: MutableState<Int>,
) {

    val walkingDurationInMillis = getDurationInMillis(walking)
    val joggingDurationInMillis = getDurationInMillis(jogging)
    val pauseDurationInMillis = getDurationInMillis(pause)

    val walkingCountDown = remember {
        mutableStateOf(walkingDurationInMillis)
    }
    val joggingCountDown = remember {
        mutableStateOf(joggingDurationInMillis)
    }
    val pauseCountDown = remember {
        mutableStateOf(pauseDurationInMillis)
    }

//    val durationInMillis: Int = getDurationInMillis()

//    val countDown = remember {
//        mutableStateOf(durationInMillis)
//    }

    val countDown = if (jogging.value > 30) {
        StartCountDownTimer(
            durationInMillis = walkingDurationInMillis,
            countDown = walkingCountDown
        )
        // start
        StartCountDownTimer(
            durationInMillis = (joggingDurationInMillis * 0.2).toInt(),
            countDown = joggingCountDown
        )
        // peep
        StartCountDownTimer(
            durationInMillis = pauseDurationInMillis,
            countDown = pauseCountDown
        )
        // peep
        StartCountDownTimer(
            durationInMillis = (joggingDurationInMillis * 0.5).toInt(),
            countDown = joggingCountDown
        )
        // peep
        StartCountDownTimer(
            durationInMillis = (pauseDurationInMillis * 2),
            countDown = pauseCountDown
        )
        // peep
        StartCountDownTimer(
            durationInMillis = (joggingDurationInMillis * 0.3).toInt(),
            countDown = joggingCountDown
        )
        // peep
        StartCountDownTimer(
            durationInMillis = pauseDurationInMillis,
            countDown = pauseCountDown
        )
        // peep
        StartCountDownTimer(
            durationInMillis = walkingDurationInMillis,
            countDown = walkingCountDown
        )
    } else if (jogging.value > 10) {
        StartCountDownTimer(
            durationInMillis = walkingDurationInMillis,
            countDown = walkingCountDown
        )
        // start
        StartCountDownTimer(
            durationInMillis = (joggingDurationInMillis * 0.2).toInt(),
            countDown = joggingCountDown
        )
        // peep
        StartCountDownTimer(durationInMillis = pauseDurationInMillis, countDown = pauseCountDown)
        // peep
        StartCountDownTimer(
            durationInMillis = (joggingDurationInMillis * 0.5).toInt(),
            countDown = joggingCountDown
        )
        // peep
        StartCountDownTimer(
            durationInMillis = (pauseDurationInMillis * 2),
            countDown = pauseCountDown
        )
        // peep
        StartCountDownTimer(
            durationInMillis = (joggingDurationInMillis * 0.3).toInt(),
            countDown = joggingCountDown
        )
        // peep
        StartCountDownTimer(durationInMillis = pauseDurationInMillis, countDown = pauseCountDown)
        // peep
        StartCountDownTimer(
            durationInMillis = walkingDurationInMillis,
            countDown = walkingCountDown
        )
        // finish
    } else {
        StartCountDownTimer(
            durationInMillis = walkingDurationInMillis,
            countDown = walkingCountDown
        )
        // start
        repeat(5) {
            StartCountDownTimer(
                durationInMillis = (joggingDurationInMillis * 0.2).toInt(),
                countDown = joggingCountDown
            )

            // peep
            StartCountDownTimer(
                durationInMillis = pauseDurationInMillis,
                countDown = pauseCountDown
            )
            // peep
        }
        StartCountDownTimer(
            durationInMillis = walkingDurationInMillis,
            countDown = walkingCountDown
        )
        // finish
    }

//    StartCountDownTimer(durationInMillis, countDown)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Jogging for",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold
        )
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

private fun getDurationInMillis(duration: MutableState<Int>): Int {
    return duration.value * 60 * 1000
}

@Composable
private fun StartCountDownTimer(
    durationInMillis: Int,
    countDown: MutableState<Int>,
): MutableState<Int> {
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
    return countDown
}