package com.example.ugly_galleryalpha.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.R
import com.example.ugly_galleryalpha.navigation.NavGraphScreen
import com.example.ugly_galleryalpha.navigation.ScreenSealed

import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme


@Composable
fun HomeScreen(navController: NavController){

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "UG",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )

        Lenta(
            img = R.drawable.photo1,
            nameUser = "Geralt",
            nameWork = "like",
            img1 = R.drawable.photo2,
            nameUser1 = "Over_Lord",
            nameWork1 = "My Favorite ANIME",
            navController = navController
        )

        Lenta(
            img = R.drawable.photo3,
            nameUser = "Mr_Wagner",
            nameWork = "GUUUNS!!!",
            img1 = R.drawable.photo4,
            nameUser1 = "Машка Рофляшка",
            nameWork1 = "Моя кошка",
            navController = navController
        )


    }
}


// Элемент ленты (пост)
@Composable
fun PostLenta(
    img: Int,
    nameUser: String,
    nameWork: String,
    navController: NavController // Добавлен параметр navController
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
                painter = painterResource(id = img),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = nameUser
        )
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = nameWork,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.padding(bottom = 8.dp))
    }
}

// Лента
@Composable
fun Lenta(
    img: Int,
    nameUser: String,
    nameWork: String,
    img1: Int,
    nameUser1: String,
    nameWork1: String,
    navController: NavController
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            PostLenta(img, nameUser, nameWork, navController) // Передаем navController в PostLenta
            Spacer(modifier = Modifier.padding(8.dp))
            PostLenta(img1, nameUser1, nameWork1, navController) // Передаем navController в PostLenta
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Ugly_galleryALPHATheme {
        HomeScreen(rememberNavController())
    }
}