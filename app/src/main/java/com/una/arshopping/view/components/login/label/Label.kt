package com.una.arshopping.view.components.login.label

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.styles.Styles

@Composable
fun Label(styles: Styles, text: String) {
    Box(
        modifier = Modifier
            .shadow(
                elevation = 2.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .border(
                width = 0.5.dp,
                color = Color(0xFFD9D9D9),
                shape = RoundedCornerShape(size = 18.dp)
            )
            .width(310.dp)
            .height(42.dp)
            .background(color = Color(0x33FFFFFF), shape = RoundedCornerShape(size = 18.dp))
    ) {
        Text(
            text = text,
            fontFamily = styles.fontFamily,
            fontSize = 32.sp,
            color = Color.Black,
            modifier = Modifier.align(alignment = Alignment.Center),
        )
    }
}