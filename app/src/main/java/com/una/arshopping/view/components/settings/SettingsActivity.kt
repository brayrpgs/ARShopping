package com.una.arshopping.view.components.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class SettingsActivity : ComponentActivity() {
    /********************************
     * init the globals variables
     * --theme
     * --fonts
     * --colors fonts
     * --functions onClicks and logics
     *********************************/

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

}