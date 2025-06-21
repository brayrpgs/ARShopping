package com.una.arshopping.view.components.main.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.zIndex
import com.una.arshopping.model.Product
import com.una.arshopping.repository.gelAllTheme
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.compare.ProductCarousel

@Composable
fun CompareButton(
    selectedProducts: Map<String, Product> = emptyMap()
) {
    val context = LocalContext.current
    val theme = gelAllTheme(context)
    var isCompare by remember { mutableStateOf(false) }
    Box {
        TextButton(
            onClick = { isCompare = true },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x80FFFFFF),
                contentColor = Color(0xFF000000)
            ),
            border = BorderStroke(1.dp, Color(0xFFFFFFFF))
        ) {
            Text(
                text = "COMPARE",
                fontFamily = Styles().fontFamily,
                color = if (theme == 1 || theme == 0) Color.Black else Color.White,
                fontSize = 35.sp
            )
        }
    }

    AnimatedVisibility(
        visible = isCompare,
        enter = slideInVertically(initialOffsetY = { 500 }) + fadeIn(),
        exit = slideOutVertically(targetOffsetY = { 500 }) + fadeOut(),
        modifier = Modifier
            .fillMaxSize()
            .zIndex(1f)
    ) {

        Column(
            modifier = Modifier
                .zIndex(2f)
                .offset(0.dp, 50.dp),
        ) {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        brush = if (theme == 1 || theme == 0) Styles().colorLightBackground else Styles().colorDarkBackground,
                        shape = RoundedCornerShape(24.dp)
                    )
            ) {
                Button(
                    onClick = { isCompare = false },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (theme == 1 || theme == 0) Color.Black else Color.White,
                        contentColor = if (theme == 1 || theme == 0) Color.White else Color.Black
                    ),
                    modifier = Modifier.padding(10.dp)
                ) {

                    Text(
                        text = "Back",
                        fontFamily = Styles().fontFamily,
                        fontWeight = FontWeight(800),
                        fontSize = 20.sp

                    )
                }
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    ProductCarousel(selectedProducts,theme)
                }
            }
        }
    }
}
