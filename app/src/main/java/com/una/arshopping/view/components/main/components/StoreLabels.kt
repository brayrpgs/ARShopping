import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextButton
import androidx.compose.ui.tooling.preview.Preview
import com.una.arshopping.styles.Styles

@Composable
fun StoreLabel(name: String, font: FontFamily) {

    TextButton(
        onClick = { /* Action */ },
        modifier = Modifier
            .height(32.dp)
            .width(81.dp)
            .background(color = Color(0x80FFFFFF),shape = RoundedCornerShape(16.dp))


    ) {

        Text(
            modifier = Modifier.fillMaxSize(),
            text = name,
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = font,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Center
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPrincipal() {
    StoreLabel("Hola", Styles().fontFamily)
}

