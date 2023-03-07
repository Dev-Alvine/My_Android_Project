package com.alvo.jetpack_design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alvo.jetpack_design.ui.theme.Jetpack_DesignTheme


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        TopAppBar(
                            title = { Text(text = "My App") },
                            backgroundColor = MaterialTheme.colors.primary
                        )
                        IconRow()
                        Imagelist()
                    }
                }
            }
        }
    }
}

@Composable
fun IconRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = "Profile",
            tint = MaterialTheme.colors.onBackground.copy(alpha = 0.6f),
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.onBackground.copy(alpha = 0.08f))
                .padding(12.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.notifications_none_24),
            contentDescription = "Notifications",
            tint = MaterialTheme.colors.onBackground.copy(alpha = 0.6f),
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.onBackground.copy(alpha = 0.08f))
                .padding(12.dp)
        )
    }
}

@Composable
fun Imagelist() {
    val imagelist = listOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5,
        R.drawable.img6,
        R.drawable.img7
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(imagelist) { image ->
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .padding(end = 8.dp),
                elevation = 4.dp,
                shape = RoundedCornerShape(16.dp)
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    alpha = 0.8f
                )
            }
        }
    }
}

@Composable
fun MyAppTheme(content: @Composable () -> Unit) {

    MaterialTheme(
        colors = myAppColors,
        typography = myAppTypography,
        content = content
    )
}

private val myAppColors = lightColors(
    primary = Color(0xFF004E98),
    primaryVariant = Color(0xFF002B56),
    onPrimary = Color.White,
    secondary = Color(0xFF8E8E93),
    secondaryVariant = Color(0xFF64646A),
    onSecondary = Color.Black,
    background = Color(0xFFF2F2F7),
    onBackground = Color.Black,
)

private val myAppTypography = Typography(
    h4 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        letterSpacing = 0.25.sp
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp)
)

fun DefaultPreview() {

}