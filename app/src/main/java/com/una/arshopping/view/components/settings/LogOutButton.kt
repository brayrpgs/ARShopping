package com.una.arshopping.view.components.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
fun LogOutButton(
    colorContent: Color = Color.Black,
    backgroundButton: Color = Color(0x80FFFFFF)
) {

    Button(
        onClick = {},
        modifier = Modifier
            .offset(0.dp, 600.dp)
            .fillMaxWidth()
            .padding(horizontal = 55.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundButton,
            contentColor = colorContent
        ),
        border = BorderStroke(1.dp, Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.log_out),
                contentDescription = "image description",
                contentScale = ContentScale.FillHeight,
            )
            Text(
                text = "Log out",
                fontSize = 15.sp,
                fontFamily = Styles().fontFamily,
                color = colorContent
            )
        }
    }

}