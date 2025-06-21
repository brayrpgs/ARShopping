package com.una.arshopping.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.una.arshopping.model.UserOTPRequest
import com.una.arshopping.model.UserValidateOTPRequest
import com.una.arshopping.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class RecoverPasswordViewModel : ViewModel() {
    val email = mutableStateOf("")
    val otp = mutableStateOf("")
    val newPassword = mutableStateOf("")
    val confirmPassword = mutableStateOf("")

    private val _sendOTPState = MutableLiveData<SendOTPResult>()
    val sendOTPState: LiveData<SendOTPResult> = _sendOTPState

    private val _validateOTPState = MutableLiveData<ValidateOTPResult>()
    val validateOTPState: LiveData<ValidateOTPResult> = _validateOTPState

    sealed class SendOTPResult {
        data class Success(val message: String) : SendOTPResult()
        data class Error(val message: String) : SendOTPResult()
    }

    sealed class ValidateOTPResult {
        data class Success(val message: String) : ValidateOTPResult()
        data class Error(val message: String) : ValidateOTPResult()
    }

    suspend fun sendOTP(context: Context) = withContext(Dispatchers.IO) {
        try {
            val userOTPRequest = UserOTPRequest(email = email.value)
            val response = RetrofitInstance.getInstance(context).requestOTP(userOTPRequest)
            if (response.isSuccessful) {
                _sendOTPState.postValue(SendOTPResult.Success("OTP sent successfully"))
            } else {
                val errorBodyString = response.errorBody()?.string() ?: "Invalid OTP"

                val jsonObject = JSONObject(errorBodyString)
                val errorMessage = jsonObject.getString("error")
                _sendOTPState.postValue(SendOTPResult.Error(errorMessage))
            }
        } catch (e: Exception) {
            _sendOTPState.postValue(SendOTPResult.Error("Network error: ${e.message}"))
        }
    }

    fun triggerSendOTP(context: Context) {
        viewModelScope.launch {
            sendOTP(context)
        }
    }

    suspend fun validateOTP(context: Context) = withContext(Dispatchers.IO) {
        try {
            val requestUser = RetrofitInstance.getInstance(context).getUserByEmail(
                size = 1,
                page = 1,
                email = email.value
            )
            val user = requestUser.body()?.data?.users?.firstOrNull()
                ?: throw IllegalStateException("User not found")

            val userOTPRequest = UserValidateOTPRequest(
                user = user,
                otp = otp.value.trim(),
                newPassword = newPassword.value
            )
            val response = RetrofitInstance.getInstance(context).validateOTP(userOTPRequest)
            if (response.isSuccessful) {
                _validateOTPState.postValue(ValidateOTPResult.Success("Password updated"))
            } else {
                val errorBodyString = response.errorBody()?.string() ?: "Invalid OTP"

                val jsonObject = JSONObject(errorBodyString)
                val errorMessage = jsonObject.getString("error")
                _validateOTPState.postValue(ValidateOTPResult.Error(errorMessage))
            }
        } catch (e: Exception) {
            _validateOTPState.postValue(ValidateOTPResult.Error("Network error: ${e.message}"))
        }
    }

    fun triggerValidateOTP(context: Context) {
        viewModelScope.launch {
            validateOTP(context)
        }
    }
}