package com.una.arshopping.view.components.myprofile.avatarpicker

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun AvatarSection(
    avatarUrl: String,
    avatarUrls: List<String>,
    onAvatarSelected: (String) -> Unit,
    showPicker: Boolean,
    setShowPicker: (Boolean) -> Unit
) {
    val finalAvatar = if (avatarUrl.isNotEmpty()) avatarUrl else avatarUrls.first()
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.size(120.dp).clip(CircleShape), contentAlignment = Alignment.Center) {
            Image(
                painter = rememberAsyncImagePainter(finalAvatar),
                contentDescription = "Avatar",
                modifier = Modifier.size(120.dp).clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        IconButton(onClick = { setShowPicker(true) }, modifier = Modifier.size(32.dp)) {
            Icon(Icons.Default.Edit, contentDescription = "Edit Avatar", tint = Color.Black, modifier = Modifier.size(16.dp))
        }
    }

    if (showPicker) {
        AvatarPickerDialog(
            avatarUrls = avatarUrls,
            currentAvatarUrl = avatarUrl,
            onAvatarSelected = {
                onAvatarSelected(it)
                setShowPicker(false)
            },
            closeDialog = { setShowPicker(false) }
        )
    }
}