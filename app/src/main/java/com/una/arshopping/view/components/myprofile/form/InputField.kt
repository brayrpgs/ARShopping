package com.una.arshopping.view.components.myprofile.form

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    errorMessage: String?,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    Column(modifier = modifier) {
        Text(label, modifier = Modifier.align(Alignment.Start))
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            leadingIcon = leadingIcon,
            singleLine = true,
            isError = errorMessage != null
        )
        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(errorMessage, color = Color.Red, style = MaterialTheme.typography.bodySmall)
        }
    }
}

