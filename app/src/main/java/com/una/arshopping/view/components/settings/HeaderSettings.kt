package com.una.arshopping.view.components.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.R
import com.una.arshopping.styles.Styles

@Composable
fun HeaderSettings(
    onclick: () -> Unit = {},
    colorContent: Color = Color.Black,
) {
    Row(
        Modifier.offset(0.dp, 50.dp),
        verticalAlignment = Alignment.Top,
    ) {
        Button(
            onClick = { onclick() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
        }
        Text(
            "Settings",
            Modifier.padding(top = 5.dp),
            fontFamily = Styles().fontFamily,
            fontSize = 32.sp,
            color = colorContent
        )
    }
}