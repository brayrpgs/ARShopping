package com.una.arshopping.view.components.main

import android.os.Bundle
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


class PrincipalActivity : ComponentActivity() {
    private lateinit var productViewModel: ProductViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        productViewModel.getProduct()
        val userId = intent.getIntExtra("USER_ID", -1)
        val userUsername = intent.getStringExtra("USER_USERNAME") ?: ""
        val userEmail = intent.getStringExtra("USER_EMAIL") ?: ""
        val userAvatarUrl = intent.getStringExtra("USER_AVATAR_URL") ?: ""
        enableEdgeToEdge()
        setContent {

            MainScreen(productViewModel, userId, userUsername, userEmail, userAvatarUrl)

        }
    }


    @Composable
    fun MainScreen(
        productViewModel: ProductViewModel,
        userId: Int,
        userUsername: String,
        userEmail: String,
        userAvatarUrl: String
    ) {
        val productResponse by productViewModel.products.observeAsState()


        val products = productResponse



        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Styles().colorLightBackground)
                .fillMaxSize()
        ) {


            MainLayout(products, userId, userUsername, userEmail, userAvatarUrl)
        }
    }
}


