package com.una.arshopping.view.components.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.main.layout.MainLayout
import com.una.arshopping.viewmodel.ProductViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
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
            AnimatedEntry{
                MainScreen(productViewModel)
            }
        }
    }

    @Composable
    fun AnimatedEntry(content: @Composable () -> Unit) {
        var visible by remember { mutableStateOf(false) }


        LaunchedEffect(Unit) {
            visible = true
        }

        val alpha by animateFloatAsState(
            targetValue = if (visible) 1f else 0f,
            animationSpec = tween(durationMillis = 600)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = alpha)
        ) {
            content()
        }
    }


    @Composable
    fun MainScreen(
        productViewModel: ProductViewModel
    ) {
        val context = LocalContext.current
        /**
         * gets data products by observer pattern
         */
        val productResponse by productViewModel.products.observeAsState()
        val products = productResponse

        var searchQuery by remember { mutableStateOf("") }
        var searchStore by remember { mutableStateOf("") }
        var currentPage by remember { mutableIntStateOf(1) }

        fun loadPage(page: Int) {
            currentPage = page
            productViewModel.getProductsFiltered(
                context = context,
                page = page,
                query = searchQuery,
                store = searchStore
            )
        }

        LaunchedEffect(Unit) {
            loadPage(1)
        }

        /**
         * get to local storage theme and set it
         */

        var numberTheme by remember { mutableIntStateOf(gelAllTheme(context)) }
        var colorBackground =
            if (numberTheme == 1 || numberTheme == 0) Styles().colorLightBackground else Styles().colorDarkBackground
        Log.d("THEME_FETCH", "theme: $colorBackground")
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(colorBackground)
                .fillMaxSize()
        ) {
            MainLayout(
                productResponse = products,
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                store = searchStore,
                onStoreChange = { searchStore = it },
                onSearch = { loadPage(1) },
                onPageChange = { page -> loadPage(page) }
            )
        }
    }
}


