package com.una.arshopping.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.una.arshopping.model.UserRequest
import com.una.arshopping.network.RetrofitInstance
import com.una.arshopping.repository.deleteUser
import com.una.arshopping.repository.insert
import kotlinx.coroutines.launch

class SingInViewModel : ViewModel() {
    private val _singInState = MutableLiveData<Boolean>()
    val singInState: LiveData<Boolean> = _singInState

    private var _emailUsedForSignUp: String? = null
    fun setEmail(email: String) {
        _emailUsedForSignUp = email
    }
    fun getEmail(): String? = _emailUsedForSignUp

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

    fun recoverCreatedUser(email: String, context: Context){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.getInstance(context).getUserByEmail(
                    size = 1,
                    page = 1,
                    email = email
                )
                Log.i("SignInViewModel", "Recovered user info: ${response}")
                val user = response.body()?.data?.users?.get(0)

                deleteUser(context)
                insert(context, user)

            } catch (e: Exception) {
                Log.e("SINGIN", "Exception trying to recovered the created user info", e)
                _singInState.value = false
            }
        }
    }

}