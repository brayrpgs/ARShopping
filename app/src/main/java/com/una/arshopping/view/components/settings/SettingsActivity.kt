package com.una.arshopping.view.components.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.una.arshopping.viewmodel.UserViewModel

class SettingsActivity : ComponentActivity() {
    /********************************
     * init the globals variables
     * --theme
     * --fonts
     * --colors fonts
     * --functions onClicks and logics
     * --view model
     *********************************/
    private lateinit var userViewModel: UserViewModel

    /**
     * gets the theme
     */
    //val themeNumber = gelAllTheme(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * init the view model
         */
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]


        enableEdgeToEdge()
        setContent {
            Background {
                Glass {
                    HeaderSettings()
                    DivisorSettings()
                    LabelAccount()
                    LoginMethod()
                    ChangePassword(viewModel = userViewModel)
                    LogOutButton()
                    DeleteAccount()
                }
            }
        }
    }

}