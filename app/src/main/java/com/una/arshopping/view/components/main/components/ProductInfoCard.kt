package com.una.arshopping.view.components.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
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
    selected: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    val openDialog = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.clickable { openDialog.value = true }
    ) {
        Card(
            modifier = Modifier
                .width(160.dp)
                .height(250.dp),
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
                        .clip(RoundedCornerShape(24.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = heading,
                    fontSize = 14.sp,
                    maxLines = 4
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = price,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                    )

                    Checkbox(
                        checked = selected,
                        onCheckedChange = onCheckedChange,
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Black,
                            uncheckedColor = Color.Gray,
                            checkmarkColor = Color.White
                        )
                    )
                }
            }
        }
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = heading) },
            text = {
                Column {
                    Image(
                        painter = rememberAsyncImagePainter(imageRes),
                        contentDescription = "Product image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.FillHeight
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Price: $price",
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left
                        )
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text(
                        text = "Close",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Normal,
                        )
                    )
                }
            }
        )
    }
}
