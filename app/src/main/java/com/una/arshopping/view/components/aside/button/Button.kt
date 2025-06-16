package com.una.arshopping.view.components.aside.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.styles.Styles

@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    contentColor: Color = Color.White,
    modifier: Modifier = Modifier,
    @DrawableRes iconId: Int,
    iconContentDescription: String? = null,
    themeNumber : Int = 0
) {
    val styles = Styles()
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (themeNumber == 1 || themeNumber == 0) Color(0x80D9D9D9) else Color(0x80FFFFFF),
            contentColor = contentColor,
        )
    ) {

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                painter = painterResource(id = iconId),
                contentDescription = iconContentDescription,
                tint = contentColor,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(30.dp)
            )

            Text(
                text = text,
                style = TextStyle(
                    fontFamily = styles.fontFamily,
                    fontSize = 20.sp,
                    color = contentColor
                )
            )
        }
    }
}
