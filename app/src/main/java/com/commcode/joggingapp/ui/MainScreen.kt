package com.commcode.joggingapp.ui

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
    val walking: MutableState<Int> = rememberSaveable {
        mutableStateOf(joggingUnit.walking)
    }
    val jogging: MutableState<Int> = rememberSaveable { mutableStateOf(joggingUnit.jogging) }
    val pause: MutableState<Int> = rememberSaveable {
        mutableStateOf(joggingUnit.pause)
    }

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        if (shouldShowExerciseScreen) {
            StartScreen(
                onStartClicked = { shouldShowExerciseScreen = false },
                jogging = jogging
            )
        } else {
            ExerciseScreen(modifier = modifier, walking = walking, jogging = jogging, pause = pause)
        }
    }
}