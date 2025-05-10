package com.una.arshopping.view.components.login.recovery

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.styles.Styles

@Composable
fun RecoveryPass(css: Styles, backgroundColor : Brush, create : () -> Unit = {}, forgot : () -> Unit = {}) {
    val color = if (backgroundColor == css.colorDarkBackground) Color.White else Color.Black
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
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
            onClick = {
                forgot()
            },
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(
                text = "Forgot password?",
                fontFamily = css.fontFamily,
                color = color
            );
        }
        TextButton(
            onClick = {
                create()
            },
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(
                text = "Create account?",
                fontFamily = css.fontFamily,
                color = color,
                fontSize = 13.sp
            );
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecoveryPass() {
    RecoveryPass(Styles(), Styles().colorDarkBackground)
}