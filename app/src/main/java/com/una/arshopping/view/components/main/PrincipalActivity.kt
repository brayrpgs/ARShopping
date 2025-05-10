package com.una.arshopping.view.components.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.main.layout.MainLayout


class PrincipalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val userId = intent.getIntExtra("USER_ID", -1)
        val userUsername = intent.getStringExtra("USER_USERNAME") ?: ""
        val userEmail = intent.getStringExtra("USER_EMAIL") ?: ""
        val userAvatarUrl = intent.getStringExtra("USER_AVATAR_URL") ?: ""

        setContent {
            MainScreen(userId, userUsername, userEmail, userAvatarUrl)
        }
    }
}

@Composable
fun MainScreen(userId: Int, userUsername: String, userEmail: String, userAvatarUrl: String) {
    Column(
       horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Styles().colorLightBackground)
            .fillMaxSize()

    ){

        MainLayout(userId, userUsername, userEmail, userAvatarUrl)


    }

}
/*
@Preview(showBackground = true)
@Composable
fun PreviewPrincipal() {
    MainScreen()

}
*/

