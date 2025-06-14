package com.una.arshopping.view.components.aside.content

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainBox(userId: Int, userUsername: String, userEmail: String, userAvatarUrl: String) {

    Box {
        Background()
        AsideBox(userId, userUsername, userEmail, userAvatarUrl)

    }

}
/*
@Preview(showBackground = true)
@Composable
fun PreviewMainBox() {
    MainBox()
}*/