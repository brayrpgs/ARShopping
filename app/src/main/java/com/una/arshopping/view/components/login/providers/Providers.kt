package com.una.arshopping.view.components.login.providers

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.una.arshopping.R
import com.una.arshopping.repository.deleteUser
import androidx.core.net.toUri

@Composable
fun Providers() {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 22.dp)
            )
            .width(300.dp)
            .height(68.dp)
            .background(color = Color(0x33D9D9D9), shape = RoundedCornerShape(size = 22.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        FilledIconButton(
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Color.Transparent
            ),
            onClick = {
                deleteUser(context)
                val intent = Intent(Intent.ACTION_VIEW, "http://10.0.2.2:3000/auth/google".toUri())
                context.startActivity(intent)
                (context as? Activity)?.finish()
            },
            modifier = Modifier
                .width(53.dp)
                .height(53.dp),
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.icongoogle),
                    contentDescription = "google",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .width(53.dp)
                        .height(53.dp),
                )
            }


        )

        FilledIconButton(
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Color.Transparent
            ),
            onClick = {
                deleteUser(context)
                val intent = Intent(Intent.ACTION_VIEW, "http://10.0.2.2:3000/auth/github".toUri())
                context.startActivity(intent)
                (context as? Activity)?.finish()
            },
            modifier = Modifier
                .width(53.dp)
                .height(53.dp),
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.githubicon),
                    contentDescription = "github",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .width(53.dp)
                        .height(53.dp),
                )
            }

        )
        FilledIconButton(
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Color.Transparent
            ),
            onClick = {
                deleteUser(context)
                val intent = Intent(Intent.ACTION_VIEW, "http://10.0.2.2:3000/auth/facebook".toUri())
                context.startActivity(intent)
                (context as? Activity)?.finish()
            },
            modifier = Modifier
                .width(53.dp)
                .height(53.dp),
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.facebookicon),
                    contentDescription = "Facebook",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .width(53.dp)
                        .height(53.dp),
                )
            }

        )

    }
}