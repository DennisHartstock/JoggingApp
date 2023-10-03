package com.commcode.joggingapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.LocationOn
import androidx.compose.material.icons.twotone.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    val titleResId: Int,
    val icon: ImageVector,
) {
    object Start : NavigationItem(
        titleResId = R.string.navigation_item_start,
        icon = Icons.TwoTone.Home
    )

    object Music :
        NavigationItem(
            titleResId = R.string.navigation_item_music,
            icon = Icons.TwoTone.PlayArrow
        )

    object Track :
        NavigationItem(
            titleResId = R.string.navigation_item_track,
            icon = Icons.TwoTone.LocationOn
        )
}
