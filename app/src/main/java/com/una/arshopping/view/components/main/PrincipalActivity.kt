package com.una.arshopping.view.components.main

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
import com.una.arshopping.view.components.main.components.CompareButton
import com.una.arshopping.view.components.main.layout.MainLayout


class PrincipalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()

        }
    }
}

@Composable
fun MainScreen() {
    Column(
       horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Styles().colorLightBackground).fillMaxSize()
    ){
        Spacer(modifier = Modifier.height(42.dp))
        MainLayout()
        Spacer(modifier = Modifier.height(18.dp))
        CompareButton(font = Styles().fontFamily)
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewPrincipal() {
    MainScreen()

}


