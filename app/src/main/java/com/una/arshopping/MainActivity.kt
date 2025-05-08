package com.una.arshopping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.ui.theme.ARShoppingTheme

// MainActivity is the entry point for the app and sets up the UI with a Drawer and Blur Effect
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enabling edge-to-edge support
        setContent {

            ARShoppingTheme { // Applying the theme to the composable UI
                DrawerWithBlurEffect() // Calling the DrawerWithBlurEffect composable
            }
        }
    }
}

// Composable function that creates a Drawer with a blur effect
@OptIn(ExperimentalMaterial3Api::class) // Opting in to experimental APIs
@Composable
fun DrawerWithBlurEffect() {
    var isDrawerOpen by remember { mutableStateOf(false) } // State to manage whether the drawer is open or not

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

                // Drawer panel (aside)
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(300.dp)
                        .border(width = 2.dp, color = Color.White)
                        .background(Color(0xFF93D5FC)) // Light blue background color
                        .padding(16.dp)
                        .padding(top = 5.dp)
                ) {

                    Column {
                        // The content of the drawer with rounded corners
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(800.dp)
                                .clip(RoundedCornerShape(24.dp)) // Rounded corners for the drawer
                                .background(Color(0xFF93D5FC)) // Same background color
                                .border(2.dp, Color.White, RoundedCornerShape(24.dp)) // White border
                                .padding(16.dp)
                        ) {
                            Column {
                                // Spacer for vertical spacing
                                Spacer(modifier = Modifier.height(50.dp))

                                // Drawer title
                                Text(
                                    text = "ShoppingAR",
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold, // Bold title
                                        fontSize = 24.sp, // Font size for the title
                                        color = Color.Black
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentWidth(Alignment.CenterHorizontally) // Center-align the title
                                )

                                // Horizontal divider line
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(4.dp)
                                        .background(Color.White)
                                )

                                // Spacer for vertical spacing
                                Spacer(modifier = Modifier.height(10.dp))

                                val buttonColor = Color(0xFFDAE2ED) // Light blue color for buttons

                                // Column to contain the buttons inside the drawer
                                Column(
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    // Profile Button
                                    Button(
                                        onClick = { /* Some action */ },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = buttonColor,
                                            contentColor = Color.Black
                                        ),
                                        shape = RoundedCornerShape(6.dp),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(35.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.AccountCircle, // Profile icon
                                                contentDescription = "Profile",
                                                modifier = Modifier
                                                    .align(Alignment.CenterStart)
                                                    .offset(x = (-10).dp)
                                                    .size(32.dp)
                                            )
                                            Text(
                                                text = "My profile", // Text for the button
                                                fontSize = 20.sp,
                                                modifier = Modifier.align(Alignment.Center)
                                            )
                                        }
                                    }
                                    // Spacer for vertical spacing
                                    Spacer(modifier = Modifier.height(15.dp))

                                    // Preferences Button
                                    Button(
                                        onClick = { /* Some action */ },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = buttonColor,
                                            contentColor = Color.Black
                                        ),
                                        shape = RoundedCornerShape(6.dp),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(35.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Favorite, // Favorite icon
                                                contentDescription = "Preferences",
                                                modifier = Modifier
                                                    .align(Alignment.CenterStart)
                                                    .offset(x = (-10).dp)
                                                    .size(32.dp)
                                            )
                                            Text(
                                                text = "Preferences", // Text for the button
                                                fontSize = 20.sp,
                                                modifier = Modifier.align(Alignment.Center)
                                            )
                                        }
                                    }
                                    // Spacer for vertical spacing
                                    Spacer(modifier = Modifier.height(15.dp))

                                    // Settings Button
                                    Button(
                                        onClick = { /* Some action */ },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = buttonColor,
                                            contentColor = Color.Black
                                        ),
                                        shape = RoundedCornerShape(6.dp),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(35.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Settings, // Settings icon
                                                contentDescription = "Settings",
                                                modifier = Modifier
                                                    .align(Alignment.CenterStart)
                                                    .offset(x = (-10).dp)
                                                    .size(32.dp)
                                            )
                                            Text(
                                                text = "Settings", // Text for the button
                                                fontSize = 20.sp,
                                                modifier = Modifier.align(Alignment.Center)
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        // Dark Mode Icon with Blur Effect
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                                .height(50.dp)

                        ) {
                            Icon(
                                imageVector = Icons.Default.Brightness4, // Brightness icon (dark mode)
                                contentDescription = "DarkMode",
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(128.dp) // Icon size increased for visibility
                            )
                        }
                    }
                }

                // Overlay with a blur effect when the drawer is open
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .background(Color.Black.copy(alpha = 0.5f)) // Black overlay with transparency
                        .blur(20.dp) // Blur effect applied to the background
                        .pointerInput(Unit) {
                            detectTapGestures(onTap = { isDrawerOpen = false }) // Close the drawer on tap
                        }
                )
            }
        }
    }
}

// Preview function to render the DrawerWithBlurEffect composable
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ARShoppingTheme { // Applying the theme in the preview
        DrawerWithBlurEffect() // Previewing the drawer UI with blur effect
    }
}
