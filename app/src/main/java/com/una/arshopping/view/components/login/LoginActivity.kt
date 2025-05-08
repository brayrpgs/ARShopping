package com.una.arshopping.view.components.login

import TextInput
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.una.arshopping.view.components.login.imagecover.ImageCover
import com.una.arshopping.view.components.login.label.Label
import com.una.arshopping.view.components.login.providers.Providers
import com.una.arshopping.view.components.login.recovery.RecoveryPass
import com.una.arshopping.view.components.login.themeschema.ThemeSchema

class LoginActivity : ComponentActivity() {
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
        Spacer(Modifier.height(104.dp))
        Label(styles, text = "Welcome", backgroundColor = colorBackground)
        Spacer(Modifier.height(27.dp))
        ImageCover()
        Spacer(Modifier.height(26.dp))
        Label(styles, text = "Shopping AR", backgroundColor = colorBackground)
        Spacer(Modifier.height(54.dp))
        Label(styles, text = "Log In", backgroundColor = colorBackground)
        Spacer(Modifier.height(6.dp))
        Providers()
        Spacer(Modifier.height(20.dp))
        TextInput(
            styles = styles,
            label = "User",
            placeholder = "Enter your user",
            isPassword = false,
            backgroundColor = colorBackground
        )
        Spacer(Modifier.height(9.dp))
        TextInput(
            styles = styles,
            label = "Password",
            placeholder = "Enter your Password",
            isPassword = true,
            backgroundColor = colorBackground
        )
        Spacer(Modifier.height(8.dp))
        RecoveryPass(css = styles, backgroundColor = colorBackground)
        Spacer(Modifier.height(7.dp))
        ThemeSchema(
            colorBackground = {
                if (colorBackground == styles.colorLightBackground) {
                    colorBackground = styles.colorDarkBackground
                } else {
                    colorBackground = styles.colorLightBackground
                }
            },
            backgroundColor = colorBackground
        )

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLabel() {
    Background(Styles())
}