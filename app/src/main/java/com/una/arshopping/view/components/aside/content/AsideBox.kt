package com.una.arshopping.view.components.aside.content

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.R
import com.una.arshopping.repository.gelAllTheme
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.aside.button.Button
import com.una.arshopping.view.components.myprofile.MyProfileActivity
import com.una.arshopping.view.components.preferences.PreferencesActivity
import com.una.arshopping.view.components.settings.SettingsActivity

@Composable
fun AsideBox() {
    val context = LocalContext.current
    /**************
     * define styles global
     */
    val themeNumber = gelAllTheme(context)
    val styles = Styles()
    val fontColor = if (themeNumber == 1 || themeNumber == 0) Color.Black else Color.White
    Box(
        Modifier
            .padding(start = 5.dp, top = 20.dp)

            .border(
                width = 1.dp,
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 24.dp)
            )
            .width(320.dp)
            .height(830.dp)
            .background(color = Color(0x1A000000), shape = RoundedCornerShape(size = 24.dp))
            .offset(0.dp, 55.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Shopping Engine Search",
                    style = TextStyle(
                        fontFamily = styles.fontFamily,
                        fontSize = 25.sp,
                        color = fontColor
                    )
                )

                Spacer(modifier = Modifier.height(25.dp))

                val buttons = listOf(
                    Triple("My profile", R.drawable.account_circle) {
                        val intent = Intent(context, MyProfileActivity::class.java)
                        context.startActivity(intent)
                        (context as? Activity)?.finish()
                    },
                    Triple("Preferences", R.drawable.preferences) {
                        val intent = Intent(context, PreferencesActivity::class.java)
                        context.startActivity(intent)
                        (context as? Activity)?.finish()
                    },
                    Triple("Settings", R.drawable.settings) {
                        val intent = Intent(context, SettingsActivity::class.java)
                        context.startActivity(intent)
                        (context as? Activity)?.finish()
                    }
                )

                buttons.forEach { (label, iconId, action) ->
                    Spacer(modifier = Modifier.height(25.dp))

                    Button(
                        text = label,
                        iconId = iconId,
                        iconContentDescription = label,
                        onClick = {action()},
                        contentColor = fontColor,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 25.dp)
                            .border(1.dp,Color.White, RoundedCornerShape(10.dp)),
                        themeNumber = themeNumber


                    )
                }
            }
        }

    }
}