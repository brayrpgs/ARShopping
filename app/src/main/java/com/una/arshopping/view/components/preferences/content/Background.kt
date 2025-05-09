package com.una.arshopping.view.components.preferences.content

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.styles.Styles

@Composable
fun Background(styles: Styles){
    Box(
        Modifier
            //.shadow(elevation = 3.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
            .border(width = 1.dp, color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 24.dp))
            .padding(top = 25.dp)
            .width(395.dp)
            .height(875.dp)
            .background(color = Color(0x1A000000), shape = RoundedCornerShape(size = 24.dp))
    ) {
        PreferencesBox(styles)
    }
}
