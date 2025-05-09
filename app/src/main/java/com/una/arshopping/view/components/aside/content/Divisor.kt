package com.una.arshopping.view.components.aside.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

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