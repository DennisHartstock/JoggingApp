package com.commcode.joggingapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.commcode.joggingapp.JoggingUnit
import com.commcode.joggingapp.NavigationItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
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

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {

            val selectedNavigationItem = remember {
                mutableStateOf(0)
            }

            val navigationItems = listOf(
                NavigationItem.Start,
                NavigationItem.Music,
                NavigationItem.Track
            )

            navigationItems.forEachIndexed { index, navigationItem ->
                BottomAppBar {
                    NavigationBarItem(
                        selected = selectedNavigationItem.value == index,
                        onClick = { selectedNavigationItem.value = index },
                        icon = {
                            Icon(
                                imageVector = navigationItem.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = stringResource(id = navigationItem.titleResId))
                        }
                    )
                }
            }
        }
    ) {
        if (shouldShowExerciseScreen) {
            StartScreen(
                onStartClicked = { shouldShowExerciseScreen = false },
                jogging = jogging
            )
        } else {
            ExerciseScreen(
                modifier = modifier,
                walking = walking,
                jogging = jogging,
                pause = pause
            )
        }
    }
}