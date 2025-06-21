package com.una.arshopping.view.components.login

import android.app.Activity
import com.una.arshopping.view.components.login.textinput.TextInput
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.una.arshopping.model.dto.UserInfoDTO
import com.una.arshopping.repository.deleteUser
import com.una.arshopping.repository.gelAllTheme
import com.una.arshopping.repository.getAllUsers
import com.una.arshopping.repository.insert
import com.una.arshopping.repository.insertTheme
import com.una.arshopping.repository.updateTheme
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.login.imagecover.ImageCover
import com.una.arshopping.view.components.login.label.Label
import com.una.arshopping.view.components.login.providers.Providers
import com.una.arshopping.view.components.login.recovery.RecoveryPass
import com.una.arshopping.view.components.login.themeschema.ThemeSchema
import com.una.arshopping.view.components.main.PrincipalActivity
import com.una.arshopping.view.components.recover_password.RecoverPasswordEmailActivity
import com.una.arshopping.view.components.singin.SingIn
import com.una.arshopping.viewmodel.LoginViewModel
import kotlin.jvm.java

class LoginActivity : ComponentActivity() {
    /**
     * variable theme
     */
    private var previousTheme = 0

    /**
     * this is the viewmodel login
     */
    private lateinit var loginViewModel: LoginViewModel

    /**********************************************
     * method to intent access to browsers
     * @param intent
     */
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val data = intent.data
        if (data?.scheme == "arshopping" && data.host == "auth") {
            val email = data.getQueryParameter("email")
            val username = data.getQueryParameter("username")
            val avatar_url = data.getQueryParameter("avatar_url")
            val isActive = data.getQueryParameter("isActive")
            Log.d(
                "GET_DATA",
                "email: $email, username: $username, avatar_url: $avatar_url isActive: $isActive"
            )
            val user = UserInfoDTO(
                id = 1,
                email = email!!,
                username = username!!,
                avatarUrl = avatar_url,
                isActive = isActive == "1"
            )
            Log.d("GET_DATA_BY_WEB", "user: $user")
            insert(this, user)
            val intent = Intent(this, PrincipalActivity::class.java)
            this.startActivity(intent)
            finish()
        }
    }


    override fun onResume() {
        super.onResume()
        val currentTheme = gelAllTheme(this)
        Log.d("THEME_CURRENT", "theme: $currentTheme")
        Log.d("THEME_PREVIOUS", "theme: $previousTheme")
        if (currentTheme != previousTheme) {
            previousTheme = currentTheme
            Log.d("THEME_CHANGED", "theme: $currentTheme")
            recreate()
        }
    }

    /**
     * on create function ,
     * initialize view model and observer login state
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * set the previous theme
         */
        previousTheme = gelAllTheme(this)


        super.onCreate(savedInstanceState)

        /**
         * initialize view model
         */
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        /**
         * function to observe login state
         */
        loginViewModel.loginState.observe(this, Observer { loginSuccess ->
            if (loginSuccess) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Login")
                builder.setMessage("Login successful. Welcome back!")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                val intent = Intent(this, PrincipalActivity::class.java)
                this.startActivity(intent)
                finish()
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Login")
                builder.setMessage("Login failed. Please check your credentials.")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                val dialog = builder.create()
                dialog.show()
            }
        })


        /**
         * function to observe user information
         */
        loginViewModel.user.observe(this, Observer { user ->
            if (user != null) {
                insert(this, user)
            }
        })

        /**
         * design and components
         */
        enableEdgeToEdge()
        setContent {
            Background(
                styles = Styles(),
                loginViewModel = loginViewModel,
            )
        }

        /**
         * check if user is logged in
         */
        val user = getAllUsers(this)
        if (user.isNotEmpty()) {
            val intent = Intent(this, PrincipalActivity::class.java)
            this.startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

@Composable
fun Background(styles: Styles, loginViewModel: LoginViewModel) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val context = LocalContext.current

    /**
     * get theme
     */
    var theme = gelAllTheme(context)
    Log.d("THEME_FETCH", "theme: $theme")
    var colorBackground by remember { mutableStateOf(styles.colorLightBackground) }
    if (theme == 0) {
        colorBackground = styles.colorLightBackground
        insertTheme(context, 1)
    }
    /**
     * set the theme
     */
    if (theme == 1) {
        colorBackground = styles.colorLightBackground
        Log.d("THEME_SELECTED", "theme: $theme")
    } else if (theme == 2) {
        colorBackground = styles.colorDarkBackground
        Log.d("THEME_SELECTED", "theme: $theme")
    } else {
        colorBackground = styles.colorLightBackground
        Log.d("THEME_SELECTED", "theme: $theme")
    }
    Log.d("THEME_SELECTED", "colorBackground: $colorBackground")

    Column(
        modifier = Modifier
            .background(colorBackground)
            .fillMaxSize()
            .width(440.dp)
            .height(956.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(Modifier.height(104.dp))
        Label(styles, text = "Welcome", backgroundColor = colorBackground)
        Spacer(Modifier.height(27.dp))
        ImageCover()
        Spacer(Modifier.height(26.dp))
        Label(styles, text = "Shopping AR", backgroundColor = colorBackground)
        Spacer(Modifier.height(54.dp))
        Label(styles, text = "Log In", backgroundColor = colorBackground)
        Spacer(Modifier.height(6.dp))
        Providers()
        Spacer(Modifier.height(20.dp))
        TextInput(
            styles = styles,
            label = "Email",
            placeholder = "Enter your Email",
            isPassword = false,
            backgroundColor = colorBackground,
            input = email
        )
        Spacer(Modifier.height(9.dp))
        TextInput(
            styles = styles,
            label = "Password",
            placeholder = "Enter your Password",
            isPassword = true,
            backgroundColor = colorBackground,
            event = {
                deleteUser(context)
                loginViewModel.validateUser(email.value, password.value, context)
            },
            input = password
        )
        Spacer(Modifier.height(8.dp))
        RecoveryPass(
            css = styles,
            backgroundColor = colorBackground,
            create = {
                val intent = Intent(context, SingIn::class.java)
                context.startActivity(intent)
                (context as? Activity)?.finish()

            },
            forgot = {
                val intent = Intent(context, RecoverPasswordEmailActivity::class.java)
                context.startActivity(intent)
                (context as? Activity)?.finish()
            }
        )
        Spacer(Modifier.height(7.dp))
        /**
         * get the theme from the database and set the theme
         */
        ThemeSchema(
            colorBackground = {
                if (colorBackground == styles.colorLightBackground) {
                    colorBackground = styles.colorDarkBackground
                    updateTheme(context, 2)
                    theme = 2
                } else {
                    colorBackground = styles.colorLightBackground
                    updateTheme(context, 1)
                    theme = 1
                }
            },
            backgroundColor = colorBackground
        )

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLabel() {
    Background(Styles(), LoginViewModel())
}