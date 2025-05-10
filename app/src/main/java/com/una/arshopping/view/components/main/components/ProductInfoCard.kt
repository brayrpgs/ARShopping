package com.una.arshopping.view.components.main.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.R

@Composable
fun ProductInfoCard(
    imageRes: Int,
    heading: String,
    price: String,
    description: String
) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(160.dp) // altura reducida
            ,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Product image",
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = heading,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Start
            )
            Text(
                text = price,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Start
            )
            Text(
                text = description,
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Start
            )
        }
    }
}
