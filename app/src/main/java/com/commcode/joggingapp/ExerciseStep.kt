package com.commcode.joggingapp

sealed class ExerciseStep(
    title: Int,
    icon: Int,
    duration: Int,
) {
    object Walking : ExerciseStep(R.string.walking_for, R.drawable.walking, 1)
    object Jogging : ExerciseStep(R.string.jogging_for, R.drawable.jogging, 1)
}
