package com.una.arshopping.view.components.settings

import android.app.Activity
import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.una.arshopping.R
import com.una.arshopping.repository.deleteUser
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.login.LoginActivity
import com.una.arshopping.viewmodel.UserViewModel

@Composable
fun DeleteAccount(
    colorContent: Color = Color.Black,
    backgroundButton: Color = Color(0xBFFF0004),
    viewModel: UserViewModel
) {
    val context = LocalContext.current
    var isDelete by remember { mutableStateOf(false) }
    Button(
        onClick = { isDelete = true },
        modifier = Modifier
            .offset(0.dp, 675.dp)
            .fillMaxWidth()
            .padding(horizontal = 55.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundButton,
            contentColor = colorContent
        ),
        border = BorderStroke(1.dp, Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.alert_triangle),
                contentDescription = "image description",
                contentScale = ContentScale.FillHeight,
            )
            Text(
                text = "Delete account",
                fontSize = 15.sp,
                fontFamily = Styles().fontFamily,
                color = Color.White
            )
        }
    }

    AnimatedVisibility(
        visible = isDelete,
        enter = slideInVertically(initialOffsetY = { 500 }) + fadeIn(),
        exit = slideOutVertically(targetOffsetY = { 500 }) + fadeOut(),
        modifier = Modifier
            .fillMaxSize()
            .zIndex(1f)
    ) {
        Column(
            modifier = Modifier
                .zIndex(2f)
                .offset(0.dp, 740.dp),
        ) {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Are you sure you want to delete your account?",
                    fontFamily = Styles().fontFamily,
                    fontWeight = FontWeight(800),
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp)

                )
                Button(
                    onClick = {
                        viewModel.deleteUser(
                            context = context,
                            onSuccess = {
                                isDelete = false
                                deleteUser(context)
                                val intent = Intent(context, LoginActivity::class.java)
                                context.startActivity(intent)
                                (context as? Activity)?.finish()
                            },
                            onError = {
                                isDelete = false
                            }
                        )
                        isDelete = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xBFFF0000),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 50.dp
                        )
                        .height(40.dp),
                    border = BorderStroke(1.dp, Color.White)
                ) {
                    Text(
                        "Delete account",
                        fontFamily = Styles().fontFamily,
                        fontWeight = FontWeight(800),
                        fontSize = 13.sp
                    )
                }
                Button(
                    onClick = {
                        isDelete = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFFFFF),
                        contentColor = Color.Black
                    ),
                    border = BorderStroke(1.dp, Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 50.dp
                        )
                        .height(40.dp),

                    ) {
                    Text(
                        "Cancel",
                        fontFamily = Styles().fontFamily,
                        fontWeight = FontWeight(800),
                        fontSize = 13.sp
                    )

                }

            }
        }
    }
}