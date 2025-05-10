package com.una.arshopping.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.una.arshopping.model.LoginRequest
import com.una.arshopping.model.dto.UserInfoDTO
import com.una.arshopping.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginState = MutableLiveData<Boolean>()
    val loginState: LiveData<Boolean> = _loginState

    private val _user = MutableStateFlow<UserInfoDTO?>(null)
    val user: StateFlow<UserInfoDTO?> get() = _user

    fun validateUser(email: String, password: String) {
        viewModelScope.launch {
            val response = RetrofitInstance.api.login(
                LoginRequest(
                    email = email,
                    password = password
                )
            )

            if (response.isSuccessful) {
                val loginResponse = response.body()
                _user.value = loginResponse?.user

                Log.i("LOGIN", "Usuario logueado: ${_user.value?.username}, correo: ${user.value?.email}")
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