package com.una.arshopping.view.components.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.imageLoader
import com.una.arshopping.R

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
                    ChangePassword()
                    LogOutButton()
                    DeleteAccount()
                }
            }
        }
    }

    @Composable
    fun LogOutButton() {
        Button(
            onClick = {},
            modifier = Modifier
                .offset(0.dp, 600.dp)
                .fillMaxWidth()
                .padding(horizontal = 55.dp)
                .height(50.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.log_out),
                contentDescription = "image description",
                contentScale = ContentScale.FillHeight,
            )
        }
    }

    @Composable
    fun DeleteAccount() {
        Button(
            onClick = {},
            modifier = Modifier
                .offset(0.dp, 675.dp)
                .fillMaxWidth()
                .padding(horizontal = 55.dp)
                .height(50.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.alert_triangle),
                contentDescription = "image description",
                contentScale = ContentScale.FillHeight,
            )
        }
    }
}