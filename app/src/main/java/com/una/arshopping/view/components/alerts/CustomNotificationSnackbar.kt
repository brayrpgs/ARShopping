package com.una.arshopping.view.components.alerts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomNotificationSnackbar(message: String, isSuccess: Boolean) {
    val background = Color(0xFFE0F7FA)
    val borderColor = if (isSuccess) Color(0xFF4CAF50) else Color(0xFFF44336)
    val icon = if (isSuccess) Icons.Default.Check else Icons.Default.Close
    val iconColor = if (isSuccess) Color(0xFF4CAF50) else Color(0xFFF44336)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 12.dp)
            .border(1.dp, borderColor, RoundedCornerShape(16.dp))
            .background(background, RoundedCornerShape(16.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null, tint = iconColor)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = message, color = Color.Black)
        }
    }
}