package com.una.arshopping.view.components.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextButton
import androidx.compose.ui.tooling.preview.Preview
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.main.layout.MainLayout

@Composable
fun CompareButton(font: FontFamily) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(52.dp)
            .shadow(
                elevation = 1.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000),
                shape = RoundedCornerShape(20.dp)
            )
            .background(
                color = Color(0x1AFFFFFF),
                shape = RoundedCornerShape(20.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        TextButton(onClick = { /* Action */ }) {
            Text(
                text = "COMPARE",
                style = TextStyle(
                    fontSize = 32.sp,
                    lineHeight = 40.sp,
                    fontFamily = font,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}
