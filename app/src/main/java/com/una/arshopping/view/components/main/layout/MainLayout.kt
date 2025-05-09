package com.una.arshopping.view.components.main.layout

import StoreLabel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.R
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.main.MainScreen
import com.una.arshopping.view.components.main.components.CompareButton
import com.una.arshopping.view.components.main.components.ContentBox
import com.una.arshopping.view.components.main.components.MainFrame
import com.una.arshopping.view.components.main.components.Pagination
import com.una.arshopping.view.components.main.components.ProductInfoCard
import com.una.arshopping.view.components.main.components.SearchBar

@Composable
fun MainLayout() {
    val font = Styles().fontFamily

    Box(
        modifier = Modifier
            .width(370.dp)
            .height(782.dp)
    ) {
        MainFrame {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(42.dp))

                Text(
                    text = "ShoppingAR Engine Search",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 40.sp,
                        fontFamily = font,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .width(285.dp)
                        .height(26.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                SearchBar()
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth().height(30.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    StoreLabel("Amazon",font)
                    StoreLabel("Alibaba",font)
                    StoreLabel("Ebay",font)
                }
                Spacer(modifier = Modifier.height(16.dp))
                ContentBox()
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewPrincipal() {
    MainLayout()

}