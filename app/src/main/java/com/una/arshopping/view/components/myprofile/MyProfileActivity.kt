package com.una.arshopping.view.components.myprofile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.una.arshopping.common.*
import com.una.arshopping.repository.deleteUser
import com.una.arshopping.repository.getAllUsers
import com.una.arshopping.repository.gelAllTheme
import com.una.arshopping.repository.insertTheme
import com.una.arshopping.repository.updateTheme
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.alerts.CustomNotificationSnackbar
import com.una.arshopping.view.components.login.LoginActivity
import com.una.arshopping.view.components.main.PrincipalActivity
import com.una.arshopping.view.components.main.ui.theme.ARShoppingTheme
import com.una.arshopping.view.components.myprofile.avatarpicker.AvatarSection
import com.una.arshopping.view.components.myprofile.button.ActionButtons
import com.una.arshopping.view.components.myprofile.form.InputField
import com.una.arshopping.view.components.preferences.button.GetBackButton
import com.una.arshopping.view.components.login.themeschema.ThemeSchema
import com.una.arshopping.viewmodel.SingInViewModel
import com.una.arshopping.viewmodel.UserViewModel
import kotlinx.coroutines.launch

/**
 * Activity displaying the user profile screen. It recovers logged in user via local db
 * and injects it into the Composable screen.
 */
class MyProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = UserViewModel()
        val styles = Styles()

        // Validate that user has been recovered correctly
        val user = getAllUsers(this)
        if (user.isEmpty()) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
            return
        }

        val userId = user[0].id
        val userUsername = user[0].username
        val userEmail = user[0].email
        val userAvatarUrl = user[0].avatarUrl

        setContent {
            ARShoppingTheme {
                if (userId != null) {
                    MyProfileScreen(styles, viewModel, userId, userUsername, userEmail, userAvatarUrl ?: "")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyProfileScreen(
    styles: Styles,
    viewModel: UserViewModel,
    userId: Int,
    userUsername: String,
    userEmail: String,
    userAvatarUrl: String
) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    var saveSuccess by remember { mutableStateOf<Boolean?>(null) }

    // Theme handling
    val context = LocalContext.current
    var theme by remember { mutableStateOf(gelAllTheme(context)) }
    var colorBackground by remember { mutableStateOf(styles.colorLightBackground) }

    // Set initial theme
    if (theme == 0) {
        colorBackground = styles.colorLightBackground
        theme = 1
    } else if (theme == 1) {
        colorBackground = styles.colorLightBackground
    } else if (theme == 2) {
        colorBackground = styles.colorDarkBackground
    } else {
        colorBackground = styles.colorLightBackground
    }

    val avatarUrls = listOf(
        "https://img.freepik.com/free-psd/bunny-emoji-icon-rendering_23-2151126085.jpg",
        "https://img.freepik.com/free-psd/bunny-emoji-icon-rendering_23-2151126116.jpg",
        "https://img.freepik.com/free-psd/bunny-emoji-icon-rendering_23-2151126077.jpg"
    )

    // Inputs that user can update
    var username by remember { mutableStateOf(userUsername) }
    var email by remember { mutableStateOf(userEmail) }
    var avatarUrl by remember { mutableStateOf(userAvatarUrl) }

    // General states
    var showImagePicker by remember { mutableStateOf(false) }
    var isModified by remember { mutableStateOf(false) }

    // Validation states
    var usernameError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(colorBackground)) {
                TopAppBar(
                    title = {
                        Text(
                            "My profile",
                            fontWeight = FontWeight.Bold,
                            fontFamily = styles.fontFamily,
                            color = if (theme == 2) Color.White else Color.Black,
                        )
                    },
                    navigationIcon = { GetBackButton(theme = theme) },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Transparent)
                )
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(Color.White)
                )
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                CustomNotificationSnackbar(
                    message = data.visuals.message,
                    isSuccess = saveSuccess == true
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(colorBackground)
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            // 1. Avatar image with edit icon
            AvatarSection(avatarUrl, avatarUrls, onAvatarSelected = {
                avatarUrl = it
                isModified = true
            }, showPicker = showImagePicker, setShowPicker = { showImagePicker = it }, theme = theme)

            Spacer(modifier = Modifier.height(40.dp))

            // 2. Username input field with validation
            InputField(
                value = username,
                onValueChange = {
                    username = it
                    isModified = true
                    usernameError = validateUsername(it)
                },
                theme = theme,
                label = "Username",
                errorMessage = usernameError,
                leadingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = null, tint = if (theme == 2) Color.White else Color.Black) }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 3. Email input field with validation
            InputField(
                value = email,
                onValueChange = {
                    email = it
                    isModified = true
                    emailError = validateEmail(it)
                },
                label = "Email",
                theme = theme,
                errorMessage = emailError,
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null, tint = if (theme == 2) Color.White else Color.Black) }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 5. Action buttons shown only if data is modified
            if (isModified) {
                Spacer(modifier = Modifier.weight(1f))
                ActionButtons(
                    onSave = {
                        if (usernameError == null && emailError == null) {
                            handleSave(
                                viewModel,
                                userId,
                                email,
                                username,
                                if (avatarUrl.isBlank()) null else avatarUrl,
                                {
                                    saveSuccess = true
                                    coroutineScope.launch { snackbarHostState.showSnackbar("Data saved") }
                                    isModified = false
                                },
                                {
                                    saveSuccess = false
                                    coroutineScope.launch { snackbarHostState.showSnackbar("Error saving data") }
                                },
                                context = context
                            )
                        } else {
                            coroutineScope.launch { snackbarHostState.showSnackbar("Please fix validation errors") }
                        }
                    },
                    onCancel = {
                        handleCancel(
                            resetUsername = { username = it },
                            resetEmail = { email = it },
                            originalUsername = userUsername,
                            originalEmail = userEmail,
                            resetModified = { isModified = false }
                        )
                    }
                )
            }
        }
    }
}