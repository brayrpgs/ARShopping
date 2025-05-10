package com.una.arshopping.viewmodel

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
        lastName: String
    ) {
        viewModelScope.launch {
            val response = RetrofitInstance.api.createUser(
                UserRequest(
                    username,
                    email,
                    password,
                    firstName,
                    lastName
                )
            )
            if (response.isSuccessful) {
                Log.i("SINGIN", "Singin exitoso. Código: ${response.code()}")
                _singInState.value = true
            } else {
                Log.e("SINGIN", "Error de Singin. Código: ${response.code()}")
                val errorText = response.errorBody()?.string()
                Log.e("SINGIN", "Mensaje: $errorText")
                _singInState.value = false
            }
        }
    }

}