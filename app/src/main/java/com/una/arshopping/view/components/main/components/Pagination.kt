package com.una.arshopping.view.components.main.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            .height(43.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val pagesToShow = listOf(1, 2, 3, -1, totalPages - 1, totalPages) // -1 for ellipsis

        pagesToShow.forEach { page ->
            when {
                page == -1 -> {
                    Text(
                        "...",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        fontFamily = Styles().fontFamily,
                        color = Color.Black
                    )

                }

                page == currentPage -> {
                    TextButton(
                        onClick = { onPageClick(page) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        modifier = Modifier.size(43.dp, 43.dp),
                        shape = RoundedCornerShape(8.dp)

                    ) {
                        Text(text = "$page",fontFamily = Styles().fontFamily, color = Color.White)
                    }
                }

                else -> {
                    TextButton(
                        onClick = { onPageClick(page) },
                        modifier = Modifier.size(43.dp, 43.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "$page",fontFamily = Styles().fontFamily, color = Color.Black)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPrincipal() {
    Pagination(1, 67, {})

}