package com.una.arshopping.view.components.aside.blur

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun Blur(onTapOutside: () -> Unit) {
    Box(
        modifier = Modifier

            .width(109.dp)
            .height(956.dp)
            .background(color = Color(0x6E000000))
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    onTapOutside()
                })
            }
    )
}
