package com.una.arshopping.common

import com.una.arshopping.model.dto.UserUpdateDTO
import com.una.arshopping.viewmodel.UserViewModel

// Save handler: sends update request to ViewModel and invokes result callbacks
fun handleSave(
    viewModel: UserViewModel,
    userId: Int,
    email: String,
    username: String,
    avatarUrl: String,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
) {
    val user = UserUpdateDTO(email = email, username = username, avatarUrl = avatarUrl)
    viewModel.updateUser(userId, user, onSuccess, onError)
}

// Cancel handler: resets input fields to original values
fun handleCancel(
    resetUsername: (String) -> Unit,
    resetEmail: (String) -> Unit,
    originalUsername: String,
    originalEmail: String,
    resetModified: () -> Unit
) {
    resetUsername(originalUsername)
    resetEmail(originalEmail)
    resetModified()
}

// Username validation logic
fun validateUsername(username: String): String? {
    return when {
        username.length < 3 || username.length > 63 -> "Username must be between 3 and 63 characters"
        !username.matches(Regex("^[a-zA-Z0-9_]+\$")) -> "Only letters, numbers, and underscores allowed"
        else -> null
    }
}

// Email validation logic
fun validateEmail(email: String): String? {
    return when {
        email.isBlank() -> "Email is required"
        email.length < 5 || email.length > 63 -> "Email must be between 5 and 63 characters"
        !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid email format"
        else -> null
    }
}