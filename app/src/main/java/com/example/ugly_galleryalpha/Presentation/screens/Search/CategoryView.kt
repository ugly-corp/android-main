package com.example.ugly_galleryalpha.Presentation.screens.Search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.ugly_galleryalpha.R
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme

@Composable
fun CategoryView(name_category: String, imageUrl: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(135.dp)
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f)) // Прозрачный чёрный слой
            )

            Text(
                text = name_category,
                fontSize = 40.sp,
                color = Color.White.copy(alpha = 0.5f),
                modifier = Modifier
                    .align(Alignment.CenterStart) // Выравниваем текст по центру левого края
                    .padding(start = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewCategoryPreview() {
    Ugly_galleryALPHATheme {
        CategoryView("Еда", "https://example.com/photo.jpg")
    }
}
