package com.una.arshopping.view.components.compare

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.google.accompanist.pager.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.una.arshopping.model.Product
import androidx.core.net.toUri

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductCarousel(selectedProducts: Map<String, Product>, theme: Int = 0) {
    val context = LocalContext.current
    Column {
        selectedProducts.values.forEach { product ->
            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                color = if (theme == 1 || theme == 0) Color.Black else Color.White
            )

            val imageUrls = product.images.map { it.url }
            val pagerState = rememberPagerState()
            val scope = rememberCoroutineScope()

            HorizontalPager(
                count = imageUrls.size,
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
            ) { page ->
                val painter: Painter = rememberAsyncImagePainter(imageUrls[page])
                Image(
                    painter = painter,
                    contentDescription = "Imagen ${page + 1} de ${product.name}",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp),
                activeColor = Color.Gray
            )

            Text(
                "Precio: ${product.price} ${product.typeCoin}", fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                color = if (theme == 1 || theme == 0) Color.Black else Color.White
            )
            Text(
                "Tienda: ${product.store}", fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                color = if (theme == 1 || theme == 0) Color.Black else Color.White
            )
            Text(
                "Consultado el: ${product.dateConsulted}", fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                color = if (theme == 1 || theme == 0) Color.Black else Color.White
            )

            Text(
                text = "Ver en la web",
                color = if (theme == 1 || theme == 0) Color.Black else Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .clickable {
                        val browserIntent =
                            Intent(Intent.ACTION_VIEW, product.urlIdentifier.toUri())
                        context.startActivity(browserIntent)
                    },
                textDecoration = TextDecoration.Underline,

            )
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            )
        }
    }
}

private fun Nothing?.startActivity(intent: Intent) {}
