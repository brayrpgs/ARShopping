package com.una.arshopping.view.components.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.una.arshopping.view.components.main.layout.MainLayout

@Composable
fun MainFrame(content: @Composable BoxScope.() -> Unit) {

    Box(
        modifier = Modifier
            .shadow(elevation = 3.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
            .border(1.dp, Color.White, RoundedCornerShape(10.dp))
            .padding(0.5.dp)
            .width(391.dp)
            .height(831.dp)
            .background(color = Color(0x40D9D9D9), shape = RoundedCornerShape(size = 10.dp))
        ,
        content = content
    )
}

