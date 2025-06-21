package com.una.arshopping.view.components.preferences.permissions

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.una.arshopping.view.components.preferences.toggle.ToggleItem
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.una.arshopping.styles.Styles

@Composable
fun PermissionsBox(styles: Styles, theme: Int=1){

    var storage by remember { mutableStateOf(false) }
    var camera by remember { mutableStateOf(false) }
    var microphone by remember { mutableStateOf(false) }

    Column {
        ToggleItem(
            styles,
            label = "Storage",
            isChecked = storage,
            onCheckedChange = { storage = it },
            theme
        )

        ToggleItem(
            styles,
            label = "Camera",
            isChecked = camera,
            onCheckedChange = { camera = it },
            theme
        )

        ToggleItem(
            styles,
            label = "Microphone",
            isChecked = microphone,
            onCheckedChange = { microphone = it },
            theme
        )

    }

}