package com.una.arshopping.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.una.arshopping.model.LoginRequest
import com.una.arshopping.model.dto.UserInfoDTO
import com.una.arshopping.network.RetrofitInstance
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    /**
     * observability of login
     */
    private val _loginState = MutableLiveData<Boolean>()
    val loginState: LiveData<Boolean> = _loginState

    /**
     * user information
     */

    private val _user = MutableLiveData<UserInfoDTO?>(null)
    val user: LiveData<UserInfoDTO?> get()= _user

    /**
     * validate user with email and password
     */
    fun validateUser(
        email: String,
        password: String,
        context: Context
    ) {
        viewModelScope.launch {
            try {

                val response = RetrofitInstance.getInstance(context).login(
                    LoginRequest(
                        email = email,
                        password = password
                    )
                )

                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    _user.value = loginResponse?.user
                    Log.i("LOGIN", "Login success. code: ${response.code()}")
                    _loginState.value = true
                } else {
                    Log.e("LOGIN", "Error of login. code: ${response.code()}")
                    val errorText = response.errorBody()?.string()
                    Log.e("LOGIN", "message: $errorText")
                    _loginState.value = false
                }
            } catch (e: Exception) {
                Log.e("LOGIN", "Excepción durante el login", e)
                _loginState.value = false
            }
        }
    }

}