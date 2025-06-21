package com.una.arshopping.view.components.recover_password

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.una.arshopping.common.validateEmail
import com.una.arshopping.repository.gelAllTheme
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.login.LoginActivity
import com.una.arshopping.view.components.login.label.Label
import com.una.arshopping.view.components.recover_password.button.GoBackButton
import com.una.arshopping.view.components.singin.ButtonNormal
import com.una.arshopping.viewmodel.RecoverPasswordViewModel

class RecoverPasswordEmailActivity : ComponentActivity() {
    private lateinit var recoverPasswordViewModel: RecoverPasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val styles = Styles()
        recoverPasswordViewModel = ViewModelProvider(this)[RecoverPasswordViewModel::class.java]

        recoverPasswordViewModel.sendOTPState.observe(this, Observer { result ->
            when (result) {
                is RecoverPasswordViewModel.SendOTPResult.Success -> {
                    val intent = Intent(this, RecoverPasswordOTPActivity::class.java)
                    intent.putExtra("email", recoverPasswordViewModel.email.value)
                    startActivity(intent)
                }
                is RecoverPasswordViewModel.SendOTPResult.Error -> {
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
            RecoverPasswordScreen(styles, recoverPasswordViewModel, this@RecoverPasswordEmailActivity)
        }
    }
}

@Composable
fun RecoverPasswordScreen(styles: Styles, viewModel: RecoverPasswordViewModel, context: Context) {
    var emailError by remember { mutableStateOf<String?>(null) }
    val theme = gelAllTheme(context)
    val colorBackground = if (theme == 2) styles.colorDarkBackground else styles.colorLightBackground
    val color = if (colorBackground == styles.colorDarkBackground) Color.White else Color.Black

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
            GoBackButton(LoginActivity::class.java, theme)
            Spacer(Modifier.width(12.dp))
            Label(styles = styles, text = "Recover Password", backgroundColor = colorBackground)
        }

        Spacer(Modifier.height(70.dp))
        OutlinedTextField(
            value = viewModel.email.value,
            onValueChange = {
                viewModel.email.value = it
                emailError = validateEmail(it)
            },
            label = {
                Text(
                    text = "Email",
                    fontFamily = styles.fontFamily,
                    fontSize = 10.sp,
                    color = color
                )
            },
            shape = RoundedCornerShape(size = 25.dp),
            placeholder = {
                Text(
                    text = "",
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontFamily = styles.fontFamily
                )
            },
            textStyle = TextStyle(
                fontFamily = styles.fontFamily,
                fontSize = 18.sp,
                color = color
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color,
                unfocusedBorderColor = color
            )
        )
        emailError?.let {
            Spacer(modifier = Modifier.height(4.dp))
            Text(it, color = Color.Red, style = MaterialTheme.typography.bodySmall)
        }
        Spacer(Modifier.height(40.dp))
        ButtonNormal(
            "Send OTP",
            colorBackground
        ) { viewModel.triggerSendOTP(context) }
    }
}