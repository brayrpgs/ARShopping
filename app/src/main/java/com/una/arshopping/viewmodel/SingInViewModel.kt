package com.una.arshopping.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.una.arshopping.model.UserRequest
import com.una.arshopping.network.RetrofitInstance
import kotlinx.coroutines.launch

class SingInViewModel : ViewModel() {
    private val _singInState = MutableLiveData<Boolean>()
    val singInState: LiveData<Boolean> = _singInState

    fun createUser(
        username: String,
        email: String,
        password: String,
        firstName: String,
        lastName: String,
        context: Context

    ) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.getInstance(context).createUser(
                    UserRequest(
                        username,
                        email,
                        password,
                        firstName,
                        lastName
                    )
                )
                if (response.isSuccessful) {
                    Log.i("SINGIN", "Sign-in successful. Code: ${response.code()}")
                    _singInState.value = true
                } else {
                    Log.e("SINGIN", "Sign-in failed. Code: ${response.code()}")
                    val errorText = response.errorBody()?.string()
                    Log.e("SINGIN", "Message: $errorText")
                    _singInState.value = false
                }
            } catch (e: Exception) {
                Log.e("SINGIN", "Exception during sign-in", e)
                _singInState.value = false
            }
        }
    }


}