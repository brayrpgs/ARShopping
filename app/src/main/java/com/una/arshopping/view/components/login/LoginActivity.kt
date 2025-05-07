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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.login.imagecover.ImageCover
import com.una.arshopping.view.components.login.label.Label
import com.una.arshopping.view.components.login.providers.Providers

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
    Column(
        modifier = Modifier
            .background(styles.colorLightBackground)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(Modifier.height(104.dp))
        Label(styles, text = "Welcome")
        Spacer(Modifier.height(27.dp))
        ImageCover()
        Spacer(Modifier.height(46.dp))
        Label(styles, text = "Shopping AR")
        Spacer(Modifier.height(74.dp))
        Label(styles, text = "Log In")
        Spacer(Modifier.height(6.dp))
        Providers()
        Spacer(Modifier.height(40.dp))
        TextInput(
            styles,
            modifier = Modifier,
            label = "User",
            placeholder = "Enter your user",
            isPassword = false
        )
        Spacer(Modifier.height(9.dp))
        TextInput(
            styles,
            modifier = Modifier,
            label = "Password",
            placeholder = "Enter your Password",
            isPassword = true
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLabel() {
    Background(Styles())
}