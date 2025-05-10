package com.una.arshopping.view.components.myprofile.avatarpicker

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun AvatarPickerDialog(
    avatarUrls: List<String>,
    currentAvatarUrl: String,
    onAvatarSelected: (String) -> Unit,
    closeDialog: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { },
        title = { Text("Select Avatar") },
        text = {
            Column {
                avatarUrls.forEach { avatarUrl ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                onAvatarSelected(avatarUrl)
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(avatarUrl),
                            contentDescription = "Avatar",
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Avatar ${avatarUrls.indexOf(avatarUrl) + 1}")
                        Spacer(modifier = Modifier.weight(1f))
                        if (avatarUrl == currentAvatarUrl) {
                            Icon(Icons.Default.Check, contentDescription = "Selected")
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = { closeDialog() }) {
                Text("Cancel")
            }
        },
        dismissButton = {}
    )
}