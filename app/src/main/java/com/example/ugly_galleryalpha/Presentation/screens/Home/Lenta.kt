package com.example.ugly_galleryalpha.Presentation.screens.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ugly_galleryalpha.Domain.model.postLentaModel

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