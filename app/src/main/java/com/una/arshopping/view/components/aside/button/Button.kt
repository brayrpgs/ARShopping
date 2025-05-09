package com.una.arshopping.view.components.aside.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.styles.Styles

@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    contentColor: Color = Color.White,
    backgroundColor: Color = Color(0xFFB0CCDE),
    modifier: Modifier = Modifier
) {
    val styles = Styles()
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor.copy(alpha = 0.95f),
            contentColor = contentColor
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = styles.fontFamily,
                fontSize = 20.sp,
                color = contentColor,

            )
        )
    }
}
