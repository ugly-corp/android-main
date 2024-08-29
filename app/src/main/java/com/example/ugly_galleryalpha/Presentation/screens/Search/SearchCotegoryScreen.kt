package com.example.ugly_galleryalpha.Presentation.screens.Search

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ugly_galleryalpha.Data.Api.RetrofitInstance
import com.example.ugly_galleryalpha.Data.NetWorkCategoryImpl
import com.example.ugly_galleryalpha.Domain.UseCase.Category.GetCategoryUseCase
import com.example.ugly_galleryalpha.Domain.model.DataX
import com.example.ugly_galleryalpha.Domain.model.categoryModel
import com.example.ugly_galleryalpha.R
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme
import kotlinx.coroutines.launch


@Composable
fun SearchCategoryScreen() {
    var categories by remember { mutableStateOf(emptyList<DataX>()) }
    var loading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

    val coroutineScope = rememberCoroutineScope()

    // Получаем категории из API
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            try {
                val getCategoryUseCase = GetCategoryUseCase(NetWorkCategoryImpl(RetrofitInstance.categoryApi))
                getCategoryUseCase.execute { data ->
                    if (data != null) {
                        categories = data
                        Log.d("SearchCategoryScreen", "Categories loaded: $categories")
                    }
                    loading = false
                }
            } catch (e: Exception) {
                error = "Ошибка загрузки данных"
                Log.d("NetWorkApi", "BAD: ${e.message}")
                loading = false
            }
        }
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "UG",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )

        CategoryInput()

        if (loading) {
            Text("Загрузка категорий...")
        } else if (error != null) {
            Text("Ошибка: $error")
        } else {
            LazyColumn {
                items(categories) { category ->
                    CategoryView(name_category = category.name, imageUrl = category.photo) // Теперь загружаем изображение по URL
                }
            }
        }
    }
}


// Поиск по категории
@Composable
fun CategoryInput(){

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
        TODO()
    }
}