package com.example.ugly_galleryalpha.Presentation.screens.Search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme

@Composable
fun SearchCotegoryScreen(){
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

        CategoryInput()
    }
}

// Поиск по категории
@Composable
fun CategoryInput(){
    //Логин
    val category_state = remember{ mutableStateOf("") }

    OutlinedTextField(
        value = category_state.value,
        onValueChange = {
            category_state.value = it
        },
        label = {
            androidx.compose.material3.Text(text = "Поиск")
        },
        shape = RoundedCornerShape(8.dp),
    )
}
@Preview(showBackground = true)
@Composable
fun ScreenCotegorePreview() {
    Ugly_galleryALPHATheme {
        SearchCotegoryScreen()
    }
}