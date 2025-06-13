package com.una.arshopping.view.components.singin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.styles.Styles


@Composable
fun EmailInput(
    styles: Styles,
    label: String,
    placeholder: String,
    isPassword: Boolean = false,
    backgroundColor: Brush,
    event: () -> Unit = {},
    input: MutableState<String>,
) {
    val color = if (backgroundColor == styles.colorDarkBackground) Color.White else Color.Black
    var text by remember { input }

    // Regex para validar el email
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
    val isValidEmail = emailPattern.matches(text)

    Box {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text(
                    text = label,
                    fontFamily = styles.fontFamily,
                    fontSize = 10.sp,
                    color = color
                )
            },
            shape = RoundedCornerShape(size = 25.dp),
            placeholder = {
                Text(
                    text = placeholder,
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontFamily = styles.fontFamily
                )
            },
            textStyle = TextStyle(
                fontFamily = styles.fontFamily,
                fontSize = 18.sp,
                color = color,
            ),
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = if (isPassword) {
                KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done)
            } else {
                KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Done)
            },
            isError = !isValidEmail && text.isNotEmpty(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (!isValidEmail && text.isNotEmpty()) Color.Red else Color.DarkGray,
                unfocusedBorderColor = if (!isValidEmail && text.isNotEmpty()) Color.Red else Color.White
            ),
            modifier = Modifier
                .width(303.dp)
                .height(85.dp),
            keyboardActions = KeyboardActions(
                onDone = {
                    event()
                }
            ),
            supportingText = {
                if (!isValidEmail && text.isNotEmpty()) {
                    Text(
                        text = "Please enter a valid email address",
                        color = Color.Red,
                        fontSize = 12.sp,
                        fontFamily = styles.fontFamily
                    )
                }
            }
        )
    }
}

