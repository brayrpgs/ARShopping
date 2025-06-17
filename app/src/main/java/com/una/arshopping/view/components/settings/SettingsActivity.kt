package com.una.arshopping.view.components.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.R
import com.una.arshopping.styles.Styles

class SettingsActivity : ComponentActivity() {
    /********************************
     * init the globals variables
     * --theme
     * --fonts
     * --colors fonts
     * --functions onClicks and logics
     */

    /**
     * gets the theme
     */
    //val themeNumber = gelAllTheme(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Background {
                Glass {
                    HeaderSettings()
                    DivisorSettings()
                    LabelAccount()
                    LoginMethod()
                }
            }
        }
    }
}