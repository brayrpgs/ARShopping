package com.una.arshopping.view.components.preferences

import android.content.Context
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.una.arshopping.repository.gelAllTheme
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.preferences.content.MainBox

class PreferencesActivity : ComponentActivity() {

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Background(Styles(), this@PreferencesActivity)
        }
    }
}

@Composable
fun Background(styles: Styles, context: Context) {
    var theme by remember { mutableIntStateOf(gelAllTheme(context)) }
    var colorBackground by remember { mutableStateOf(styles.colorLightBackground) }

    if (theme == 0) {
        colorBackground = styles.colorLightBackground
        theme = 1
    } else if (theme == 1) {
        colorBackground = styles.colorLightBackground
    } else if (theme == 2) {
        colorBackground = styles.colorDarkBackground
    } else {
        colorBackground = styles.colorLightBackground
    }

    Column(
        modifier = Modifier
            .background(colorBackground)
            .fillMaxSize()
            .width(440.dp)
            .height(956.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        MainBox(styles, theme)
    }
}

/*
@Preview(showBackground = true)
@Composable
fun PreviewLabel() {
    Background(Styles())
} */