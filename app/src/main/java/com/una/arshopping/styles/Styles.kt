package com.una.arshopping.styles

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.una.arshopping.R

data class Styles(
    val colorLightBackground: Brush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFFFFFFF),
            Color(0xFF90D5FF),
            Color(0xFFADD8E6)
        ),
        start = Offset(0f, 0f),
        end = Offset(0f, 1000f)
    ),
    val colorDarkBackground: Brush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFA29D9D),
            Color(0xFF000000),
            Color(0xFF000000)
        ),
        start = Offset(0f, 0f),
        end = Offset(0f, 1000f)
    ),
    val provider: GoogleFont.Provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    ),
    val fontName: GoogleFont = GoogleFont("JetBrains Mono"),
    val fontFamily: FontFamily = FontFamily(
        Font(
            googleFont = fontName,
            fontProvider = provider,
            weight = FontWeight.W400,
            style = FontStyle.Normal
        )
    ),
)
