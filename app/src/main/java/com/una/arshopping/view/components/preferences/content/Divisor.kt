package com.una.arshopping.view.components.preferences.content
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex


@Composable
fun Divisor() {

    Box(
        Modifier

            .offset(0.dp, 115.dp)
            .zIndex(1f)

    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(color = Color(0xFFFFFFFF))

        )
    }

}