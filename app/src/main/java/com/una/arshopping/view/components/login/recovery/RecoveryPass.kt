package com.una.arshopping.view.components.login.recovery

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.una.arshopping.styles.Styles

@Composable
fun RecoveryPass(css: Styles, backgroundColor : Brush) {
    val color = if (backgroundColor == css.colorDarkBackground) Color.White else Color.Black

    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 25.dp)
            )
            .width(303.dp)
            .height(53.dp)
            .background(color = Color(0x33D9D9D9), shape = RoundedCornerShape(size = 25.dp))
    ) {
        TextButton(
            onClick = {},
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Forgot password?",
                fontFamily = css.fontFamily,
                color = color
            );
        }
    }
}