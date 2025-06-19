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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.una.arshopping.styles.Styles

@Composable
fun StoreLabel(
    name: String,
    store: String,
    onStoreChange: (String) -> Unit,
    onSearch: () -> Unit,
    font: FontFamily
) {

    val isSelected = store == name

    TextButton(
        onClick = {
            if (!isSelected) {
                onStoreChange(name)
                onSearch()
            }
        },
        modifier = Modifier
            .height(35.dp)
            .width(81.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = if (isSelected) Color.White else Color(0x80FFFFFF),
            contentColor = if (isSelected) Color.Black else Color.DarkGray
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = font,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}


