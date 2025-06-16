package com.una.arshopping.view.components.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.main.layout.MainLayout
import com.una.arshopping.viewmodel.ProductViewModel
import androidx.compose.runtime.livedata.observeAsState
import com.una.arshopping.repository.gelAllTheme


class PrincipalActivity : ComponentActivity() {
    private lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /******************
         * get the products from the database or localhost
         */
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        productViewModel.getProduct(context = this)
        enableEdgeToEdge()
        setContent {
            MainScreen(productViewModel)
        }
    }


    @Composable
    fun MainScreen(
        productViewModel: ProductViewModel
    ) {
        /**
         * gets data products by observer pattern
         */
        val productResponse by productViewModel.products.observeAsState()
        val products = productResponse

        /**
         * get to local storage theme and set it
         */
        val numberTheme = gelAllTheme(this)
        val theme = if(numberTheme == 1 || numberTheme == 0) Styles().colorLightBackground else Styles().colorDarkBackground
        Log.d("THEME_FETCH", "theme: $theme")


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(theme)
                .fillMaxSize()
        ) {
            MainLayout(products)
        }
    }
}


