package com.una.arshopping.view.components.main.layout

import StoreLabel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.aside.blur.Blur
import com.una.arshopping.view.components.aside.content.MainBox
import com.una.arshopping.view.components.main.components.CompareButton
import com.una.arshopping.view.components.main.components.ContentBox
import com.una.arshopping.view.components.main.components.MainFrame
import com.una.arshopping.view.components.main.components.MenuButton
import com.una.arshopping.view.components.main.components.SearchBar

@Composable
fun MainLayout() {
    val font = Styles().fontFamily
    var isMenuOpen by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {

        if (isMenuOpen) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .zIndex(2f)
            ) {
                MainBox()

                Blur(onTapOutside = {
                    isMenuOpen = false
                })
            }
        }

        Box(
            modifier = Modifier
                .width(370.dp)
                .height(810.dp)
                .padding(top = 25.dp)
        ) {
            MainFrame {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp, start = 10.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        MenuButton(isMenuOpen = isMenuOpen, onClick = { isMenuOpen = true })
                    }

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
                        StoreLabel("Amazon", font)
                        StoreLabel("Alibaba", font)
                        StoreLabel("Ebay", font)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    ContentBox()
                }
            }
        }

        Box(
            modifier = Modifier
                .padding(bottom = 30.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            CompareButton(font = Styles().fontFamily)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewPrincipal() {
    MainLayout()

}