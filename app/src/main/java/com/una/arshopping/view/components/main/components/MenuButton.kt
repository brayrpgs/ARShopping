package com.una.arshopping.view.components.main.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MenuButton(isMenuOpen: Boolean, onClick: () -> Unit){
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Filled.Menu, // Menu icon
            contentDescription = "Menu",
            modifier = Modifier.size(40.dp) // Size of the menu icon
        )
    }
}