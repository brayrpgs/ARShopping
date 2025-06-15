package com.una.arshopping.viewmodel

import android.content.Context
import android.util.Log
import com.una.arshopping.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.una.arshopping.model.dto.UserUpdateDTO
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
}

