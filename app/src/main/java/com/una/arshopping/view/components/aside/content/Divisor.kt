package com.una.arshopping.view.components.aside.content
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Divisor() {

    Box(
        Modifier

            .offset(0.dp, 130.dp)

    ) {
        Box(
            Modifier
                .width(400.dp)
                .height(3.dp)
                .background(color = Color(0xFFFFFFFF))

        )
    }

}