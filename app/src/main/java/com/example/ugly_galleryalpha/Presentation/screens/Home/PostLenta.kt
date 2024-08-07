package com.example.ugly_galleryalpha.Presentation.screens.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.Domain.model.postLentaModel
import com.example.ugly_galleryalpha.Presentation.navigation.ScreenSealed
import com.example.ugly_galleryalpha.Presentation.screens.Start.StartScreen
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme

@Composable
fun PostLenta(
    model: postLentaModel,
    navController: NavController
) {
    Column {
        Card(
            modifier = Modifier
                .size(width = 160.dp, height = 180.dp)
                .clickable {
                    navController.navigate(ScreenSealed.DetailPost.route)
                },
            elevation = 8.dp,
            shape = RoundedCornerShape(8)
        ) {
            Image(
                painter = painterResource(id = model.image_work),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = model.name_artist
        )
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = model.name_work,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.padding(bottom = 8.dp))
    }
}

