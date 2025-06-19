package com.una.arshopping.view.components.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter


@Composable
fun ProductInfoCard(
    imageRes: String,
    heading: String,
    price: String,
    //description: String
) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(240.dp)
            ,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(imageRes),
                contentDescription = "Product image",
                modifier = Modifier
                    .height(110.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                ,
                contentScale = ContentScale.Crop

            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = heading,
                fontSize = 14.sp,
                softWrap = true,
                maxLines = 4,
                modifier = Modifier,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = price,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}
