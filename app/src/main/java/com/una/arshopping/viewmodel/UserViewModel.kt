package com.una.arshopping.viewmodel

import android.content.Context
import android.util.Log
import com.una.arshopping.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.una.arshopping.model.User
import com.una.arshopping.model.dto.UserUpdateDTO
import com.una.arshopping.repository.getAllUsers
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    // Update the logged in user
    fun updateUser(
        userId: Int,
        user: UserUpdateDTO,
        onSuccess: () -> Unit,
        onError: (String) -> Unit,
        context: Context
    ) {
        viewModelScope.launch {
            try {
                _isLoading.value = true

                val updatedUser = RetrofitInstance.getInstance(context).updateUser(userId, user)

                Log.i("UserViewModel", "Successfully updated user with ID: ${updatedUser.id}")
                onSuccess()
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error updating user: ${e.message}")
                onError(e.message ?: "Unknown error")
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Update the password of the logged in user
    fun changePassword(
        password: String,
        context: Context,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        // Implement password change logic here
        val userLocal = getAllUsers(context)
        val userOrigin = User(
            id = userLocal[0].id,
            email = userLocal[0].email,
            username = userLocal[0].username,
            avatarUrl = userLocal[0].avatarUrl,
            password = password,
        )
        viewModelScope.launch {
            try {
                val updatedUser =
                    RetrofitInstance.getInstance(context).changePassword(userOrigin.id, userOrigin)
                val response = updatedUser.body()?.string()?.contains("true")
                if (response!!) {
                    onSuccess()
                } else {
                    onError()
                }
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error updating user: ${e.message}")
            }
        }
    }
}

