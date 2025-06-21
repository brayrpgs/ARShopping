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
    leadingIcon: @Composable (() -> Unit)? = null,
    theme: Int=1
) {
    Column(modifier = modifier) {
        Text(
            text = label,
            modifier = Modifier.align(Alignment.Start),
            color = if (theme == 2) Color.White else MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            leadingIcon = leadingIcon,
            singleLine = true,
            isError = errorMessage != null,
            colors = if (theme == 2) {
                OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    errorBorderColor = Color.Red,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White
                )
            } else {
                OutlinedTextFieldDefaults.colors()
            }
        )
        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}