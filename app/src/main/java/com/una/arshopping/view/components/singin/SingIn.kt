package com.una.arshopping.view.components.singin

import com.una.arshopping.view.components.login.textinput.TextInput
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.login.label.Label
import com.una.arshopping.view.components.login.themeschema.ThemeSchema
import com.una.arshopping.view.components.main.PrincipalActivity
import com.una.arshopping.viewmodel.SingInViewModel

class SingIn() : ComponentActivity() {
    private lateinit var singInViewModel: SingInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        singInViewModel = ViewModelProvider(this)[SingInViewModel::class.java]
        val styles = Styles()
        //alert
        singInViewModel.singInState.observe(this, Observer { singinSuccess ->
            if (singinSuccess) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Sing in")
                builder.setMessage("Sing in successful. Welcome!")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                    val intent = Intent(this, PrincipalActivity::class.java)
                    this.startActivity(intent)
                }
                val dialog = builder.create()
                dialog.show()
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Sing in")
                builder.setMessage("Sing in failed. Please check your fields.")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                val dialog = builder.create()
                dialog.show()
            }
        })

        enableEdgeToEdge()
        setContent {
            Background(styles, singInViewModel)
        }
    }
}

@Composable
fun Background(styles: Styles, singInViewModel: SingInViewModel) {
    var colorBackground by remember { mutableStateOf(styles.colorLightBackground) }

    /**
     * states
     * */


    var user = remember { mutableStateOf("") }
    var email = remember { mutableStateOf("") }
    var firstName = remember { mutableStateOf("") }
    var lastName = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    var confirmPassword = remember { mutableStateOf("") }
    val showPasswordError = remember {
        derivedStateOf {
            password.value.isNotEmpty() &&
                    confirmPassword.value.isNotEmpty() &&
                    password.value != confirmPassword.value
        }
    }


    Column(
        modifier = Modifier
            .background(colorBackground)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Spacer(Modifier.height(104.dp))
        Label(styles = styles, text = "Sign In", backgroundColor = colorBackground)
        Spacer(Modifier.height(42.dp))
        TextInput(
            styles = styles,
            label = "User",
            placeholder = "Enter your user",
            isPassword = false,
            backgroundColor = colorBackground,
            input = user
        )
        Spacer(Modifier.height(17.dp))
        EmailInput(
            styles = styles,
            label = "Email",
            placeholder = "Enter your Email",
            isPassword = false,
            backgroundColor = colorBackground,
            input = email
        )
        //Spacer(Modifier.height(50.dp))

        TextInput(
            styles = styles,
            label = "First Name",
            placeholder = "Enter your First Name",
            isPassword = false,
            backgroundColor = colorBackground,
            input = firstName
        )
        Spacer(Modifier.height(17.dp))

        TextInput(
            styles = styles,
            label = "Last Name",
            placeholder = "Enter your Last Name",
            isPassword = false,
            backgroundColor = colorBackground,
            input = lastName
        )

        Spacer(Modifier.height(50.dp))

        TextInput(
            styles = styles,
            label = "Password",
            placeholder = "Enter your Password",
            isPassword = true,
            backgroundColor = colorBackground,
            input = password
        )

        TextInput(
            styles = styles,
            label = "Confirm",
            placeholder = "Confirm your Password",
            isPassword = true,
            backgroundColor = colorBackground,
            input = confirmPassword,
            isError = showPasswordError.value,
            showSupportingText = showPasswordError.value,
            supportingText = {
                if (showPasswordError.value) {
                    Text(
                        text = "Passwords do not match",
                        color = Color.Red,
                        fontSize = 12.sp,
                        fontFamily = styles.fontFamily
                    )
                }
            }
        )
        Spacer(Modifier.height(20.dp))
        ButtonNormal(
            "Create Account", colorBackground,
            createUser = {
                singInViewModel.createUser(
                    user.value,
                    email.value,
                    password.value,
                    firstName.value,
                    lastName.value
                )
            }
        )
        Spacer(Modifier.height(20.dp))
        ThemeSchema(
            {
                if (colorBackground == styles.colorLightBackground) {
                    colorBackground = styles.colorDarkBackground
                } else {
                    colorBackground = styles.colorLightBackground
                }
            },
            colorBackground
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLabel() {
    Background(Styles(), SingInViewModel())
}