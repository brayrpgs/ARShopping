package com.una.arshopping.view.components.aside.content
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.una.arshopping.repository.gelAllTheme
import com.una.arshopping.repository.updateTheme
import com.una.arshopping.styles.Styles
import com.una.arshopping.view.components.login.themeschema.ThemeSchema
import com.una.arshopping.view.components.main.PrincipalActivity

@Composable
fun Background() {
    /**
     * get to local storage theme and set it
     */
    val context = LocalContext.current
    var numberTheme by remember { mutableIntStateOf(gelAllTheme(context)) }
    var colorBackground =
        if (numberTheme == 1 || numberTheme == 0) Styles().colorLightBackground else Styles().colorDarkBackground
    Log.d("THEME_FETCH", "theme: $colorBackground")

    Box(
        Modifier
            .border(width = 1.dp, color = Color(0xFFFFFFFF))
            .width(331.dp)
            .fillMaxHeight()
            .background(colorBackground)

    ) {
        Divisor()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Box(
                Modifier.size(width = 70.dp, height = 50.dp)
            ) {
                ThemeSchema(
                    colorBackground = {
                        if (colorBackground == Styles().colorLightBackground) {
                            colorBackground = Styles().colorDarkBackground
                            updateTheme(context, 2)
                            numberTheme = 2
                        } else {
                            colorBackground = Styles().colorLightBackground
                            updateTheme(context, 1)
                            numberTheme = 1
                        }
                        context as PrincipalActivity
                        context.recreate()
                    },
                    backgroundColor = colorBackground
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewBackground() {
    Background()

}
