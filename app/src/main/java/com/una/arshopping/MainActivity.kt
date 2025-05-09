package com.una.arshopping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.aside.blur.Blur
import com.una.arshopping.view.components.aside.content.Background
import com.una.arshopping.view.components.aside.content.MainBox

// MainActivity is the entry point for the app and sets up the UI with a Drawer and Blur Effect
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enabling edge-to-edge support
        setContent {


            DrawerWithBlurEffect()

        }
    }
}

// Composable function that creates a Drawer with a blur effect
@OptIn(ExperimentalMaterial3Api::class) // Opting in to experimental APIs
@Composable
fun DrawerWithBlurEffect() {
    var isDrawerOpen by remember { mutableStateOf(false) } // State to manage whether the drawer is open or not
    val styles = Styles()
    // Box to hold the main content and the overlay for the drawer
    Box(modifier = Modifier.fillMaxSize()) {

        // Main content area with a Scaffold that includes a top bar
        Scaffold(topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Menu button to open the drawer
                        IconButton(onClick = { isDrawerOpen = true }) {
                            Icon(
                                imageVector = Icons.Filled.Menu, // Menu icon
                                contentDescription = "Menu",
                                modifier = Modifier.size(40.dp) // Size of the menu icon
                            )
                        }
                    }
                })
        }, content = { innerPadding ->
            // Content area of the main screen
            Column(modifier = Modifier.padding(innerPadding)) {
                // Additional content can be placed here
            }
        })

        // If the drawer is open, display the drawer with blur effect behind it
        if (isDrawerOpen) {
            Row(modifier = Modifier.fillMaxSize()) {

                MainBox()

                Blur(onTapOutside = {
                    isDrawerOpen = false
                })
            }
        }
    }
}

// Preview function to render the DrawerWithBlurEffect composable
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    DrawerWithBlurEffect() // Previewing the drawer UI with blur effect

}
