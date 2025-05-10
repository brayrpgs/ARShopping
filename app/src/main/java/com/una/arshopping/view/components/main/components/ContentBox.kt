package com.una.arshopping.view.components.main.components


import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import com.una.arshopping.R

@Composable
fun ContentBox() {

    Column(
        modifier = Modifier
            .width(350.dp)
            .background(color = Color(0x80D9D9D9), shape = RoundedCornerShape(size = 10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Pagination(
            currentPage = 1,
            totalPages = 68,
            onPageClick = { page -> println("Ir a la página $page") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Grid manual
        Column {
            repeat(3) { // change the 3 for the result of you want in the row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    repeat(3) {
                        ProductInfoCard(
                            imageRes = R.drawable.login,
                            heading = "Text",
                            price = "$0",
                            description = "Body"
                        )
                    }
                }

            }
        }
    }
}
