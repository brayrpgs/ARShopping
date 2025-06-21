package com.una.arshopping.view.components.main.components


import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import com.una.arshopping.model.Product
import com.una.arshopping.model.ProductResponse

@Composable
fun ContentBox(
    products: ProductResponse?,
    onPageChange: (Int) -> Unit,
    selectedProducts: Map<String, Product>,
    onProductChecked: (Product, Boolean) -> Unit
) {

    Column(
        modifier = Modifier
            .width(350.dp)
            .background(color = Color(0x80D9D9D9), shape = RoundedCornerShape(size = 10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(4.dp))


        products?.data?.pagination?.let { pagination ->
            Pagination(
                currentPage = pagination.currentPage,
                totalPages = pagination.totalPages,
                onPageClick = { page ->
                    onPageChange(page)
                }
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column {
            products?.data?.products?.chunked(2)?.forEach { rowItems ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    rowItems.forEach { product ->
                        ProductInfoCard(
                            imageRes = product.images.firstOrNull()?.url ?: "",
                            heading = product.name,
                            price = product.price,
                            selected = selectedProducts[product.store]?.id == product.id,
                            onCheckedChange = { checked ->
                                onProductChecked(product, checked)
                            }
                        )
                    }

                    repeat(2 - rowItems.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}