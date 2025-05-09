package com.una.arshopping.view.components.preferences.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.preferences.button.GetBackButton
import com.una.arshopping.view.components.preferences.notifications.NotificationBox
import com.una.arshopping.view.components.preferences.permissions.PermissionsBox

@Composable
fun PreferencesBox(styles: Styles){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 45.dp, start = 15.dp),
        horizontalAlignment = Alignment.Start
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            GetBackButton()

            Text(
                text = "Preferences",
                style = TextStyle(
                    fontFamily = styles.fontFamily,
                    fontSize = 28.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(start = 12.dp)
            )
        }

        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Notifications",
            style = TextStyle(
                fontFamily = styles.fontFamily,
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold

            ),
            modifier = Modifier.padding(start = 12.dp)
        )

        NotificationBox(styles)

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Permissions",
            style = TextStyle(
                fontFamily = styles.fontFamily,
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold

            ),
            modifier = Modifier.padding(start = 12.dp)
        )

        PermissionsBox(styles)
    }
}