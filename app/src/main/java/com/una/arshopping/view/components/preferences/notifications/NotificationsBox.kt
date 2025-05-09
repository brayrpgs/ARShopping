package com.una.arshopping.view.components.preferences.notifications

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.una.arshopping.view.components.preferences.toggle.ToggleItem
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.una.arshopping.styles.Styles

@Composable
fun NotificationBox(styles: Styles){

    var statusBarEnabled by remember { mutableStateOf(false) }
    var headsUpEnabled by remember { mutableStateOf(false) }
    var lockScreenEnabled by remember { mutableStateOf(false) }

    Column {
        ToggleItem(
            styles,
            label = "Status bar",
            isChecked = statusBarEnabled,
            onCheckedChange = { statusBarEnabled = it }
        )

        ToggleItem(
            styles,
            label = "Heads up",
            isChecked = headsUpEnabled,
            onCheckedChange = { headsUpEnabled = it }
        )

        ToggleItem(
            styles,
            label = "Lock screen",
            isChecked = lockScreenEnabled,
            onCheckedChange = { lockScreenEnabled = it }
        )

    }

}