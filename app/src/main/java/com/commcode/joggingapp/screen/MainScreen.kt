package com.commcode.joggingapp.screen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.commcode.joggingapp.JoggingUnit

@Composable
fun MainScreen(modifier: Modifier = Modifier, joggingUnit: JoggingUnit) {

    var shouldShowExerciseScreen by rememberSaveable { mutableStateOf(true) }
    val duration: MutableState<Int> = rememberSaveable { mutableStateOf(joggingUnit.duration) }

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        if (shouldShowExerciseScreen) {
            StartScreen(
                onStartClicked = { shouldShowExerciseScreen = false },
                duration = duration,
            )
        } else {
            ExerciseScreen(modifier = modifier, duration = duration)
        }
    }
}