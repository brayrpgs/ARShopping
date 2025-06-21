package com.una.arshopping.view.components.settings

import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.styles.Styles

@Composable
fun LabelAccount(
    colorContent: Color = Color.Black,
) {
    Text(
        text = "Account",
        fontSize = 32.sp,
        fontFamily = Styles().fontFamily,
        color = colorContent,
        modifier = Modifier.offset(50.dp, 125.dp)
    )
}