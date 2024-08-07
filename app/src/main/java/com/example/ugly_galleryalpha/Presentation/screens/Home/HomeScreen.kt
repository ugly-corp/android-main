package com.example.ugly_galleryalpha.Presentation.screens.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.R
import com.example.ugly_galleryalpha.Domain.model.postLentaModel
import com.example.ugly_galleryalpha.ui.theme.UGBlack

import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme

//Тестовый лист для домашний страницы
private val post_list = mutableListOf(
            postLentaModel("Geralt", "Персонаж", R.drawable.photo1, "bla1", 1),
            postLentaModel("Over_lord", "Аниме", R.drawable.photo2, "bla1", 2),
            postLentaModel("Mr_wagner", "Оружие", R.drawable.photo3, "bla1", 3),
            postLentaModel("Рофло-кошки", "Кошка", R.drawable.photo4, "bla1", 4)
)


@Composable
fun HomeScreen(navController: NavController){
    //Добавление элементов тест

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(UGBlack)
    ){
        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "UG",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ){
            items(post_list){ model ->
                LentaPost(model = model)
            }
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