package com.una.arshopping.view.components.main.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.styles.Styles


@Composable
fun Pagination(
    currentPage: Int,
    totalPages: Int,
    onPageClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val maxVisiblePages = 4
        val startPage = maxOf(1, currentPage - maxVisiblePages / 2)
        val endPage = minOf(totalPages, startPage + maxVisiblePages - 1)

        if (currentPage > 1) {
            TextButton(
                onClick = { onPageClick(currentPage - 1) },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("←", fontFamily = Styles().fontFamily, color = Color.Black)
            }
        }

        if (startPage > 1) {
            Text("...", modifier = Modifier.padding(horizontal = 8.dp), color = Color.Gray)
        }

        for (page in startPage..endPage) {
            val isSelected = page == currentPage
            TextButton(
                onClick = { onPageClick(page) },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) Color.Black else Color.Transparent
                ),
                modifier = Modifier.size(42.dp, 42.dp)
            ) {
                Text(
                    "$page",
                    fontFamily = Styles().fontFamily,
                    fontSize = 10.sp,
                    color = if (isSelected) Color.White else Color.Black
                )
            }
        }

        if (endPage < totalPages) {
            Text("...", modifier = Modifier.padding(horizontal = 8.dp), color = Color.Gray)
        }

        if (currentPage < totalPages) {
            TextButton(
                onClick = { onPageClick(currentPage + 1) },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("→", fontFamily = Styles().fontFamily, color = Color.Black)
            }
        }
    }
}
