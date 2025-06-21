package com.una.arshopping.view.components.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.ui.platform.LocalContext
import com.una.arshopping.repository.gelAllTheme
import com.una.arshopping.styles.Styles

@Composable
fun CompareButton(
) {
    val context = LocalContext.current
    val theme = gelAllTheme(context)

    Box {
        TextButton(
            onClick = { /* Action */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x80FFFFFF),
                contentColor = Color(0xFF000000)
            ),
            border = BorderStroke(1.dp, Color(0xFFFFFFFF))
        ) {
            Text(
                text = "COMPARE",
                fontFamily = Styles().fontFamily,
                color= if(theme == 1 || theme == 0) Color.Black else Color.White,
                fontSize = 35.sp
            )
        }
    }
}
