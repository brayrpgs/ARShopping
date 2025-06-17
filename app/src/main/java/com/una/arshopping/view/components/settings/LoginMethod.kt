package com.una.arshopping.view.components.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.R
import com.una.arshopping.styles.Styles

@Composable
fun LoginMethod(
    colorContent: Color = Color.Black,
    textButtons: Color = Color.White,
    backgroundButtons: Color = Color.Black,
    onclickFacebook: () -> Unit = {},
    onclickGoogle: () -> Unit = {},
    onclickGithub: () -> Unit = {},
) {
    Text(
        text = "Add new login method ",
        fontSize = 22.sp,
        fontFamily = Styles().fontFamily,
        color = colorContent,
        modifier = Modifier
            .offset(55.dp, 200.dp)
    )

    Button(
        onClick = { onclickFacebook },
        modifier = Modifier
            .offset(0.dp, 235.dp)
            .fillMaxWidth()
            .padding(horizontal = 48.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundButtons,
            contentColor = backgroundButtons
        ),
        border = BorderStroke(1.dp, textButtons)

    ) {
        Image(
            painter = painterResource(id = R.drawable.facebookicon),
            contentDescription = "image description",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .padding(horizontal = 0.dp)
                .offset(-(15.dp), 0.dp)
        )
        Text(
            text = "Connect with Facebook",
            fontSize = 15.sp,
            fontFamily = Styles().fontFamily,
            color = textButtons
        )
    }

    Button(
        onClick = { onclickGithub },
        modifier = Modifier
            .offset(0.dp, 295.dp)
            .fillMaxWidth()
            .padding(horizontal = 48.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundButtons,
            contentColor = backgroundButtons
        ),
        border = BorderStroke(1.dp, textButtons)

    ) {
        Image(
            painter = painterResource(id = R.drawable.githubicon),
            contentDescription = "image description",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .padding(horizontal = 0.dp)
                .offset(-(15.dp), 0.dp),
            colorFilter = ColorFilter.tint(Color.White),
        )
        Text(
            text = "Connect with GitHub  ",
            fontSize = 15.sp,
            fontFamily = Styles().fontFamily,
            color = textButtons
        )
    }

    Button(
        onClick = { onclickGoogle },
        modifier = Modifier
            .offset(0.dp, 355.dp)
            .fillMaxWidth()
            .padding(horizontal = 48.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundButtons,
            contentColor = backgroundButtons
        ),
        border = BorderStroke(1.dp, textButtons)

    ) {
        Image(
            painter = painterResource(id = R.drawable.icongoogle),
            contentDescription = "image description",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .padding(horizontal = 0.dp)
                .offset(-(15.dp), 0.dp)
        )
        Text(
            text = "Connect with Google  ",
            fontSize = 15.sp,
            fontFamily = Styles().fontFamily,
            color = textButtons
        )
    }
}