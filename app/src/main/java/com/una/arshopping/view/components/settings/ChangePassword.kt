package com.una.arshopping.view.components.settings

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.repository.deleteUser
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.login.LoginActivity
import com.una.arshopping.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePassword(
    colorLabel: Color = Color.Black,
    viewModel: UserViewModel
) {
    val context = LocalContext.current
    Text(
        text = "Change Password",
        fontSize = 22.sp,
        fontFamily = Styles().fontFamily,
        color = colorLabel,
        modifier = Modifier
            .offset(0.dp, 455.dp)
            .fillMaxWidth()
            .padding(horizontal = 55.dp)
            .height(50.dp)
    )
    /**
     * elevate future function
     */
    var password by remember { mutableStateOf("") }
    var isValidPassword by remember { mutableStateOf(false) }
    var isShowAlert by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf("") }


    /**
     * alert state
     */

    OutlinedTextField(
        onValueChange = {
            password = it
            val regex = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
            isValidPassword = regex.matches(password)
        },
        value = password,
        modifier = Modifier
            .offset(0.dp, 490.dp)
            .fillMaxWidth()
            .padding(horizontal = 55.dp)
            .height(57.dp),
        label = {
            Text(
                text = "Write the new password",
                fontSize = 15.sp,
                fontFamily = Styles().fontFamily,
                color = colorLabel,
            )
        },
        shape = RoundedCornerShape(24.dp),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorLabel,
            unfocusedBorderColor = colorLabel
        ),
        isError = !isValidPassword,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                if (isValidPassword && password.isNotEmpty()) {
                    viewModel.changePassword(
                        password = password,
                        context = context,
                        onSuccess = {
                            result = "Password changed successfully"
                            isShowAlert = true
                        },
                        onError = {
                            result =
                                "Error changing password, intent again to change the password or more latter please"
                            isShowAlert = true
                        }
                    )
                }
            }
        )
    )

    if (!isValidPassword) {
        Log.d("Password", "Password is not valid")
        Text(
            text = "Password must be at least 8 characters long, contain at least one letter and one number",
            color = Color.Red,
            fontSize = 10.sp,
            fontFamily = Styles().fontFamily,
            minLines = 3,
            modifier = Modifier
                .offset(0.dp, 550.dp)
                .fillMaxWidth()
                .padding(horizontal = 55.dp)
                .height(50.dp)
        )
    }

    if (isShowAlert) {
        AlertDialog(
            containerColor = Color(0xE6FFFFFF),
            onDismissRequest = {
                isShowAlert = false
                if (result == "Password changed successfully") {
                    deleteUser(context)
                    val intent = Intent(context, LoginActivity::class.java)
                    context.startActivity(intent)
                }
            },
            title = { Text(text = "Change Password") },
            text = { Text(text = result) },
            confirmButton = {
                TextButton(
                    onClick = {
                        isShowAlert = false
                        if (result == "Password changed successfully") {
                            deleteUser(context)
                            val intent = Intent(context, LoginActivity::class.java)
                            context.startActivity(intent)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.Transparent
                    )
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        isShowAlert = false
                        if (result == "Password changed successfully") {
                            deleteUser(context)
                            val intent = Intent(context, LoginActivity::class.java)
                            context.startActivity(intent)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.Transparent

                    )
                ) {
                    Text("Cancel")
                }
            }
        )
    }

}

