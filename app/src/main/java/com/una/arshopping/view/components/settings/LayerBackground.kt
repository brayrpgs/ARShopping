package com.una.arshopping.view.components.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.una.arshopping.styles.Styles

@Composable
fun Background(
    backgroundColor: Brush = Styles().colorLightBackground,
    content: @Composable () -> Unit = {}
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        content()
    }
}