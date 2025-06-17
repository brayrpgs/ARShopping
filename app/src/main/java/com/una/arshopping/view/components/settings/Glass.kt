package com.una.arshopping.view.components.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun Glass(
    content: @Composable () -> Unit = {}
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(color = Color(0x1A000000), shape = RoundedCornerShape(size = 24.dp))
            .blur(10.dp)
            .zIndex(0f)
            .border(2.dp, Color.White, shape = RoundedCornerShape(size = 24.dp))
    )
    Box(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(color = Color(0x1A000000), shape = RoundedCornerShape(size = 24.dp))
            .zIndex(1f)
            .border(1.dp, Color.White, shape = RoundedCornerShape(size = 24.dp))
    ) {
        content()
    }
}