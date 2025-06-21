package com.una.arshopping.view.components.singin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.styles.Styles

@Composable
fun ButtonNormal(text: String, backgroundColor: Brush, createUser: () -> Unit = {}) {
    val color = if (backgroundColor == Styles().colorDarkBackground) Color.White else Color.Black
    TextButton(
        onClick = { createUser() },
        modifier = Modifier
            .width(303.dp)
            .height(53.dp)
            .background(color = Color(0x33D9D9D9), shape = RoundedCornerShape(size = 25.dp)),
        shape = RoundedCornerShape(25.dp),
        border = BorderStroke(width = 1.dp, color = Color.White)
    ) {
        Text(
            text,
            textAlign = TextAlign.Center,
            color = color,
            fontFamily = Styles().fontFamily,
            fontSize = 18.sp
        )
    }
}

@Preview
@Composable
fun PreviewButtonNormal() {
    ButtonNormal("create account", Styles().colorLightBackground)
}