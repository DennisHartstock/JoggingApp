package com.commcode.joggingapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun TestPreview() {
    Surface {
        Test()
        AlertDialog()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Test() {
    Column(modifier = Modifier.padding(4.dp)) {
        TextField(value = "TextField", onValueChange = {}, label = { Text(text = "label") })
        Spacer(modifier = Modifier.width(16.dp))
        OutlinedButton(
            onClick = {
            },
            shape = RectangleShape,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = "Outlined Button"
            )
        }
    }
}

@Composable
private fun AlertDialog() {
    AlertDialog(onDismissRequest = { /*TODO*/ }, confirmButton = { Text(text = "Yes") },
        dismissButton = { Text(text = "No") }, title = { Text(text = "Вопрос") }, text = {
            Text(
                text = "Может всё же в дворники? Ты же определённо тупой!"
            )
        })
}