package com.una.arshopping.view.components.aside.content

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.una.arshopping.view.components.aside.button.DarkModeButton

@Composable
fun Background() {

    Box(
        Modifier
            .border(width = 1.dp, color = Color(0xFFFFFFFF))
            .width(331.dp)
            .height(1000.dp)
            .background(color = Color(0xED90D5FF))

    ) {
        Divisor()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            DarkModeButton()
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewBackground() {
    Background()

}
