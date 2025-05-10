package com.una.arshopping.view.components.myprofile.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ActionButtons(onSave: () -> Unit, onCancel: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        PrimaryButton(text = "Save", onClick = onSave, modifier = Modifier.fillMaxWidth())
        CancelButton(text = "Cancel", onClick = onCancel, modifier = Modifier.fillMaxWidth())
    }
}