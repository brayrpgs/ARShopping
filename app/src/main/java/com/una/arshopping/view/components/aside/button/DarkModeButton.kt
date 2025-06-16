package com.una.arshopping.view.components.aside.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.una.arshopping.R

@Composable
fun DarkModeButton(){
    FilledIconButton(
        onClick = {

        },
        modifier = Modifier
            .size(42.dp)
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(size = 34.dp)
            )
            .width(60.dp)
            .height(60.dp),

        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = Color.Transparent
        )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.dark_mode),
            contentDescription = "Dark mode",
            tint = Color.Unspecified,
            modifier = Modifier
                .fillMaxSize(),
        )
    }
}