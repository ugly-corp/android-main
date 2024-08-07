package com.example.ugly_galleryalpha.Presentation.screens.Favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme


@Composable
fun FavoritePostScreen(){

    Column(modifier = Modifier.fillMaxSize()){
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth()
        ){


            Text(
                modifier = Modifier.padding(start = 43.dp, end = 43.dp),
                text = "Избранное",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritePostPreview() {
    Ugly_galleryALPHATheme {
        FavoritePostScreen()
    }
}

