package com.una.arshopping.view.components.main.layout

import StoreLabel
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.una.arshopping.model.Product
import com.una.arshopping.model.ProductResponse
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.aside.blur.Blur
import com.una.arshopping.view.components.aside.content.MainBox
import com.una.arshopping.view.components.main.components.CompareButton
import com.una.arshopping.view.components.main.components.ContentBox
import com.una.arshopping.view.components.main.components.MainFrame
import com.una.arshopping.view.components.main.components.MenuButton
import com.una.arshopping.view.components.main.components.SearchBar

@Composable
fun MainLayout(
    productResponse: ProductResponse?,
    query: String,
    onQueryChange: (String) -> Unit,
    store: String,
    onStoreChange: (String) -> Unit,
    onSearch: () -> Unit,
    onPageChange: (Int) -> Unit
) {

    val font = Styles().fontFamily
    var isMenuOpen by remember { mutableStateOf(false) }
    val selectedProducts = remember { mutableStateMapOf<String, Product>() }

    /**
     * main layout view
     */
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {

        /**
         * kendall's component button with animation
         */

        AnimatedVisibility(
            visible = isMenuOpen,
            enter = slideInHorizontally(initialOffsetX = { -300 }) + fadeIn(),
            exit = slideOutHorizontally(targetOffsetX = { -300 }) + fadeOut(),
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1f)
        ) {
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

        /**
         * is the box glass
         */
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
                        text = "Shopping Engine Search",
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
                    SearchBar(
                        query = query,
                        onQueryChange = onQueryChange,
                        onSearch = onSearch
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        StoreLabel(
                            "Amazon",
                            store = store,
                            onStoreChange = onStoreChange,
                            onSearch = onSearch,
                            font
                        )
                        StoreLabel(
                            "Alibaba",
                            store = store,
                            onStoreChange = onStoreChange,
                            onSearch = onSearch,
                            font,
                        )
                        StoreLabel(
                            "Ebay",
                            store = store,
                            onStoreChange = onStoreChange,
                            onSearch = onSearch,
                            font,
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    ContentBox(
                        products = productResponse,
                        onPageChange = onPageChange,
                        selectedProducts = selectedProducts,
                        onProductChecked = { product, checked ->
                            if (checked) {
                                selectedProducts[product.store] = product
                            } else {
                                selectedProducts.remove(product.store)
                            }
                        }
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .padding(bottom = 30.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            CompareButton(selectedProducts)
        }
    }

}

