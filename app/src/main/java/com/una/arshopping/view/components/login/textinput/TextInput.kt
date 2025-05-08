import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.una.arshopping.styles.Styles

@Composable
fun TextInput(
    styles: Styles,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String,
    isPassword: Boolean = false,
    backgroundColor : Brush
) {
    val color = if (backgroundColor == styles.colorDarkBackground) Color.White else Color.Black
    var text by remember { mutableStateOf("") }

    Box(modifier = modifier) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text(
                    text = label,
                    fontFamily = styles.fontFamily,
                    fontSize = 10.sp,
                    color = color
                )
            },
            shape = RoundedCornerShape(size = 25.dp),
            placeholder = {
                Text(
                    text = placeholder,
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontFamily = styles.fontFamily
                )
            },
            textStyle = TextStyle(
                fontFamily = styles.fontFamily,
                fontSize = 20.sp,
                color = color,
            ),
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = if (isPassword) {
                KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done)
            } else {
                KeyboardOptions.Default
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor = Color.White
            ),
            modifier = Modifier
                .width(303.dp)
                .height(63.dp)
        )
    }
}
