package com.una.arshopping.view.components.preferences

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.preferences.content.Divisor
import com.una.arshopping.view.components.preferences.content.MainBox

class PreferencesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Background(Styles())
        }
    }
}

@Composable
fun Background(styles: Styles) {
    var colorBackground by remember { mutableStateOf(styles.colorLightBackground) }
    Column(
        modifier = Modifier
            .background(colorBackground)
            .fillMaxSize()
            .width(440.dp)
            .height(956.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        MainBox(styles)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLabel() {
    Background(Styles())
}