package com.commcode.joggingapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.commcode.joggingapp.screen.MainScreen
import com.commcode.joggingapp.ui.theme.JoggingAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JoggingAppTheme {
                MainScreen(modifier = Modifier.fillMaxSize(), joggingUnit = JoggingUnit(3, 5, 1))
            }
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
            MainScreen(joggingUnit = JoggingUnit(3, 5, 1))
        }
    }
}