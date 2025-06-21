package com.una.arshopping.view.components.recover_password

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.una.arshopping.repository.gelAllTheme
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.login.label.Label
import com.una.arshopping.view.components.login.textinput.TextInput
import com.una.arshopping.viewmodel.RecoverPasswordViewModel
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import com.una.arshopping.view.components.login.LoginActivity
import com.una.arshopping.view.components.preferences.button.GetBackButton
import com.una.arshopping.view.components.singin.ButtonNormal
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import com.una.arshopping.view.components.main.PrincipalActivity
import com.una.arshopping.view.components.recover_password.button.GoBackButton

class RecoverPasswordOTPActivity : ComponentActivity() {
    private lateinit var recoverPasswordViewModel: RecoverPasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recoverPasswordViewModel = ViewModelProvider(this)[RecoverPasswordViewModel::class.java]
        val styles = Styles()
        val email = intent.getStringExtra("email") ?: ""
        recoverPasswordViewModel.email.value = email

        recoverPasswordViewModel.validateOTPState.observe(this, Observer { result ->
            when (result) {
                is RecoverPasswordViewModel.ValidateOTPResult.Success -> {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Success")
                    builder.setMessage("Password updated successfully! Please log in")
                    builder.setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    }
                    builder.create().show()
                }
                is RecoverPasswordViewModel.ValidateOTPResult.Error -> {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Error")
                    builder.setMessage(result.message)
                    builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    builder.create().show()
                }
            }
        })

        enableEdgeToEdge()
        setContent {
            val theme = gelAllTheme(this)
            val colorBackground = if (theme == 2) styles.colorDarkBackground else styles.colorLightBackground

            val showPasswordError = remember {
                derivedStateOf {
                    recoverPasswordViewModel.newPassword.value.isNotEmpty() &&
                            recoverPasswordViewModel.confirmPassword.value.isNotEmpty() &&
                            recoverPasswordViewModel.newPassword.value != recoverPasswordViewModel.confirmPassword.value
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
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    GoBackButton(RecoverPasswordEmailActivity::class.java, theme)
                    Spacer(Modifier.width(12.dp))
                    Label(styles = styles, text = "Reset Password", backgroundColor = colorBackground)
                }
                Spacer(Modifier.height(42.dp))
                TextInput(
                    styles = styles,
                    label = "OTP",
                    placeholder = "Enter OTP",
                    isPassword = false,
                    backgroundColor = colorBackground,
                    input = recoverPasswordViewModel.otp
                )
                Spacer(Modifier.height(17.dp))
                TextInput(
                    styles = styles,
                    label = "New Password",
                    placeholder = "Enter new Password",
                    isPassword = true,
                    backgroundColor = colorBackground,
                    input = recoverPasswordViewModel.newPassword
                )
                Spacer(Modifier.height(10.dp))
                TextInput(
                    styles = styles,
                    label = "Confirm",
                    placeholder = "Confirm new Password",
                    isPassword = true,
                    backgroundColor = colorBackground,
                    input = recoverPasswordViewModel.confirmPassword,
                    isError = showPasswordError.value,
                    showSupportingText = showPasswordError.value,
                    supportingText = {
                        if (showPasswordError.value) {
                            Text(
                                text = "Passwords do not match",
                                color = Color.Red,
                                fontSize = 9.sp,
                                fontFamily = styles.fontFamily
                            )
                        }
                    }
                )
                Spacer(Modifier.height(20.dp))
                ButtonNormal(
                    "Update Password",
                    colorBackground,
                    createUser = { recoverPasswordViewModel.triggerValidateOTP(this@RecoverPasswordOTPActivity) }
                )
            }
        }
    }
}