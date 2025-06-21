package com.una.arshopping.view.components.settings

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import com.una.arshopping.repository.gelAllTheme
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.login.LoginActivity
import com.una.arshopping.view.components.main.PrincipalActivity
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * init the view model
         */
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        val themeNumber = gelAllTheme(this)

        enableEdgeToEdge()
        setContent {
            Background(
                backgroundColor = if (themeNumber == 1) Styles().colorLightBackground else Styles().colorDarkBackground,
            ) {
                Glass {
                    HeaderSettings(
                        onclick = {
                            val intent = Intent(this, PrincipalActivity::class.java)
                            this.startActivity(intent)
                        },
                        colorContent = if (themeNumber == 1) Color.Black else Color.White,
                    )
                    DivisorSettings()
                    LabelAccount(
                        colorContent = if (themeNumber == 1) Color.Black else Color.White,

                        )
                    LoginMethod(
                        colorContent = if (themeNumber == 1) Color.Black else Color.White,
                        textButtons = if (themeNumber == 1) Color.Black else Color.White,
                        backgroundButtons = if (themeNumber == 1) Color.White else Color.Black,
                    )
                    ChangePassword(
                        colorLabel = if (themeNumber == 1) Color.Black else Color.White,
                        viewModel = userViewModel
                    )
                    LogOutButton(
                        colorContent = if (themeNumber == 1) Color.Black else Color.White,
                    )
                    DeleteAccount(viewModel = userViewModel)
                }
            }
        }
    }

}