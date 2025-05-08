package com.una.arshopping.view.components.login.themeschema

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.una.arshopping.R
import com.una.arshopping.styles.Styles

@Composable
fun ThemeSchema(colorBackground: () -> Unit, backgroundColor: Brush) {
    val color = if (backgroundColor == Styles().colorDarkBackground) Color.White else Color.Black
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.End
    ) {
        FilledIconButton(
            onClick = {
                colorBackground()
            },
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = color,
                    shape = RoundedCornerShape(size = 34.dp)
                )
                .width(60.dp)
                .height(60.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.dark_mode),
                contentDescription = "Facebook",
                tint = color,
                modifier = Modifier
                    .fillMaxSize(),
            )
        }

    }
}