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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.ugly_galleryalpha.model.postLentaModel
import com.example.ugly_galleryalpha.navigation.NavGraphScreen
import com.example.ugly_galleryalpha.navigation.ScreenSealed

import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme

//Тестовый лист для домашний страницы
private val post_list = mutableListOf<postLentaModel>()

@Composable
fun HomeScreen(navController: NavController){
    //Добавление элементов тест
    post_list.add(postLentaModel("Geralt", "Персонаж", R.drawable.photo1, "bla1", 1))
    post_list.add(postLentaModel("Over_lord", "Аниме", R.drawable.photo2, "bla1", 2))
    post_list.add(postLentaModel("Mr_wagner", "Оружие", R.drawable.photo3, "bla1", 3))
    post_list.add(postLentaModel("Рофло-кошки", "Кошка", R.drawable.photo4, "bla1", 4))
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
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ){
            items(post_list.size / 2){ index ->
                Lenta(
                    model1 = post_list[index * 2],
                    model2 = post_list[index * 2 + 1],
                    navController = navController
                )
            }
        }


    }
}


// Элемент ленты (пост)
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

// Лента
@Composable
fun Lenta(
    model1: postLentaModel,
    model2: postLentaModel,
    navController: NavController
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            PostLenta(model1, navController) // Передаем navController в PostLenta
            Spacer(modifier = Modifier.padding(8.dp))
            PostLenta(model2, navController) // Передаем navController в PostLenta
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