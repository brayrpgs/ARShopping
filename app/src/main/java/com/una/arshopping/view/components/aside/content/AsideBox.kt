package com.una.arshopping.view.components.aside.content

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.aside.button.Button

@Composable
fun AsideBox() {
    val styles = Styles()
    Box(
        Modifier
            .padding(start = 5.dp, top = 20.dp)
            .shadow(
                elevation = 3.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .border(
                width = 1.dp,
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 24.dp)
            )
            .width(320.dp)
            .height(825.dp)
            .background(color = Color(0x1A000000), shape = RoundedCornerShape(size = 24.dp))
            .offset(0.dp, 55.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ShoppingAR",
                    style = TextStyle(
                        fontFamily = styles.fontFamily,
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(25.dp))

                val buttons = listOf(
                    "My profile" to { /* My profile action */ },
                    "Preferences" to { /* Preferences action */ },
                    "Settings" to { /* Settings action */ }
                )

                buttons.forEach { (label, action) ->
                    Spacer(modifier = Modifier.height(25.dp))

                    Button(
                        text = label,
                        onClick = action,
                        contentColor = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 25.dp)
                    )
                }
            }
        }

    }
}