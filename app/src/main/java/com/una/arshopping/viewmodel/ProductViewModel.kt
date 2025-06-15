package com.una.arshopping.viewmodel


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.una.arshopping.model.ProductResponse
import com.una.arshopping.network.RetrofitInstance
import kotlinx.coroutines.launch


class ProductViewModel : ViewModel() {
    private val _products = MutableLiveData<ProductResponse?>()
    var products: LiveData<ProductResponse?> = _products


    fun getProduct(context: Context) {
        viewModelScope.launch {
            val response = RetrofitInstance.getInstance(context).getProducts()
            val productResponse = response.body()
            _products.value = productResponse
        }
    }

}