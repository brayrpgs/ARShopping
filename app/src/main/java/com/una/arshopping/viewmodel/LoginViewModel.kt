package com.una.arshopping.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.una.arshopping.model.LoginRequest
import com.una.arshopping.network.RetrofitInstance
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginState = MutableLiveData<Boolean>()
    val loginState: LiveData<Boolean> = _loginState


    fun validateUser(email: String, password: String) {
        viewModelScope.launch {
            val response = RetrofitInstance.api.login(
                LoginRequest(
                    email = email,
                    password = password
                )
            )
            if (response.isSuccessful) {
                Log.i("LOGIN", "Login exitoso. Código: ${response.code()}")
                _loginState.value = true
            } else {
                Log.e("LOGIN", "Error de login. Código: ${response.code()}")
                val errorText = response.errorBody()?.string()
                Log.e("LOGIN", "Mensaje: $errorText")
                _loginState.value = false
            }
        }
    }
}