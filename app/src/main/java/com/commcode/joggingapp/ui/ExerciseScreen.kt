package com.commcode.joggingapp.ui

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

    var isFinished = true

    if (ExerciseStep(
            modifier = modifier,
            text = "Walking",
            durationInMillis = walkingDurationInMillis,
            countDown = walkingCountDown
        )
    ) {
        if (ExerciseStep(
                modifier = modifier,
                text = "Jogging",
                durationInMillis = joggingDurationInMillis,
                countDown = joggingCountDown
            )
        ) {
            ExerciseStep(
                modifier = modifier,
                text = "Pause",
                durationInMillis = pauseDurationInMillis,
                countDown = pauseCountDown
            )
        }
    }


//    Walking(
//        modifier = modifier,
//        walkingDurationInMillis = walkingDurationInMillis,
//        walkingCountDown = walkingCountDown
//    )
//
//    if (walkingCountDown.value == 0) {
//        isFinished = true
//    }
//
//    if (isFinished) {
//        Jogging(
//            modifier = modifier,
//            joggingDurationInMillis = joggingDurationInMillis,
//            joggingCountDown = joggingCountDown
//        )
//        isFinished = false
//    }
//
//    if (joggingCountDown.value == 0) {
//        isFinished = true
//    }
//
//    if (isFinished) {
//        Pause(
//            modifier = modifier,
//            pauseDurationInMillis = pauseDurationInMillis,
//            pauseCountDown = pauseCountDown
//        )
//        isFinished = false
//    }

//    val durationInMillis: Int = getDurationInMillis()

//    val countDown = remember {
//        mutableStateOf(durationInMillis)
//    }

    var text: String
//    val countDown = if (jogging.value > 30) {
//        text = "Walking for"
//        startCountDownTimer(
//            durationInMillis = walkingDurationInMillis,
////            countDown = walkingCountDown
//        )
//        // start
//        text = "Jogging for"
//        startCountDownTimer(
//            durationInMillis = (joggingDurationInMillis * 0.2).roundToInt(),
////            countDown = joggingCountDown
//        )
//        // peep
//        text = "Pause for"
//        startCountDownTimer(
//            durationInMillis = pauseDurationInMillis,
////            countDown = pauseCountDown
//        )
//        // peep
//        text = "Jogging for"
//        startCountDownTimer(
//            durationInMillis = (joggingDurationInMillis * 0.5).roundToInt(),
////            countDown = joggingCountDown
//        )
//        // peep
//        text = "Pause for"
//        startCountDownTimer(
//            durationInMillis = (pauseDurationInMillis * 2),
////            countDown = pauseCountDown
//        )
//        // peep
//        text = "Jogging for"
//        startCountDownTimer(
//            durationInMillis = (joggingDurationInMillis * 0.3).roundToInt(),
////            countDown = joggingCountDown
//        )
//        // peep
//        text = "Pause for"
//        startCountDownTimer(
//            durationInMillis = pauseDurationInMillis,
////            countDown = pauseCountDown
//        )
//        // peep
//        text = "Walking for"
//        startCountDownTimer(
//            durationInMillis = walkingDurationInMillis,
////            countDown = walkingCountDown
//        )
//    } else if (jogging.value > 10) {
//        text = "Walking for"
//        startCountDownTimer(
//            durationInMillis = walkingDurationInMillis,
////            countDown = walkingCountDown
//        )
//        // start
//        text = "Jogging for"
//        startCountDownTimer(
//            durationInMillis = (joggingDurationInMillis * 0.2).roundToInt(),
////            countDown = joggingCountDown
//        )
//        // peep
//        text = "Pause for"
////        startCountDownTimer(durationInMillis = pauseDurationInMillis, countDown = pauseCountDown)
//        // peep
//        text = "Jogging for"
//        startCountDownTimer(
//            durationInMillis = (joggingDurationInMillis * 0.5).roundToInt(),
////            countDown = joggingCountDown
//        )
//        // peep
//        text = "Pause for"
//        startCountDownTimer(
//            durationInMillis = (pauseDurationInMillis * 2),
////            countDown = pauseCountDown
//        )
//        // peep
//        text = "Jogging for"
//        startCountDownTimer(
//            durationInMillis = (joggingDurationInMillis * 0.3).roundToInt(),
////            countDown = joggingCountDown
//        )
//        // peep
//        text = "Pause for"
////        startCountDownTimer(durationInMillis = pauseDurationInMillis, countDown = pauseCountDown)
//        // peep
//        text = "Walking for"
//        startCountDownTimer(
//            durationInMillis = walkingDurationInMillis,
////            countDown = walkingCountDown
//        )
//        // finish
//    } else {
//        text = "Walking for"
//        startCountDownTimer(
//            durationInMillis = walkingDurationInMillis,
////            countDown = walkingCountDown
//        )
//        // start
//        repeat(5) {
//            text = "Jogging for"
//            startCountDownTimer(
//                durationInMillis = (joggingDurationInMillis * 0.2).roundToInt(),
////                countDown = joggingCountDown
//            )
//
//            // peep
//            text = "Pause for"
//            startCountDownTimer(
//                durationInMillis = pauseDurationInMillis,
////                countDown = pauseCountDown
//            )
//            // peep
//        }
//        text = "Walking for"
//        startCountDownTimer(
//            durationInMillis = walkingDurationInMillis,
////            countDown = walkingCountDown
//        )
//        // finish
//    }

//    StartCountDownTimer(durationInMillis, countDown)

//    Column(
//        modifier = modifier,
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        text = "Walking for"
//        var countDown: MutableState<Int> =
//            startCountDownTimer(durationInMillis = walkingDurationInMillis, countDown = walkingCountDown)
//
//        text = "Jogging for"
//        countDown = startCountDownTimer(durationInMillis = joggingDurationInMillis, countDown = joggingCountDown)
//
//        text = "Pause for"
//        countDown = startCountDownTimer(durationInMillis = pauseDurationInMillis, countDown = pauseCountDown)
//
//        Text(
//            text = text,
//            style = MaterialTheme.typography.headlineLarge,
//            fontWeight = FontWeight.ExtraBold
//        )
//        Spacer(modifier = Modifier.height(24.dp))
//
////        var countDownTimer by remember { mutableStateOf(duration * 60) }
////        LaunchedEffect(key1 = countDownTimer) {
////            if (countDownTimer > 0) {
////                delay(1000)
////                countDownTimer--
////            }
////        }
//
//        Text(
//            text = "${countDown.value / 1000}",
////            text = "$countDownTimer",
//            style = MaterialTheme.typography.headlineLarge
//        )
//    }
}

@Composable
fun ExerciseStep(
    modifier: Modifier,
    text: String,
    durationInMillis: Int,
    countDown: MutableState<Int>,
): Boolean {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "$text for",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(24.dp))

        val countDown =
            startCountDownTimer(
                durationInMillis = durationInMillis,
                countDown = countDown
            )

        Text(
            text = "${countDown.value / 1000}",
            style = MaterialTheme.typography.headlineLarge
        )
    }
    return countDown.value == 0
}

private fun getDurationInMillis(duration: MutableState<Int>): Int {
    return duration.value * 60 * 1000
}

@Composable
private fun startCountDownTimer(
    durationInMillis: Int,
    countDown: MutableState<Int>,
): MutableState<Int> {

//    val countDown = remember {
//        mutableStateOf(durationInMillis)
//    }

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