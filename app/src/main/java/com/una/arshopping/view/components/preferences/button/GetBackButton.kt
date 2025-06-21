package com.una.arshopping.view.components.preferences.button
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.una.arshopping.view.components.main.PrincipalActivity

@Composable
fun GetBackButton(
    theme: Int = 1
){
    val context = LocalContext.current
    Box(
        contentAlignment = Alignment.Center
    ) {
        FilledIconButton(
            onClick = {
                val intent = Intent(context, PrincipalActivity::class.java)
                context.startActivity(intent)
                (context as? Activity)?.finish()
            },
            modifier = Modifier
                .size(30.dp)
                .width(60.dp)
                .height(60.dp),

            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Color.Transparent
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "Get back",
                tint = if (theme == 2) Color.White else Color.Black,
                modifier = Modifier
                    .fillMaxSize(),
            )
        }
    }
}