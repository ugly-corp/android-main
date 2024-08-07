package com.example.ugly_galleryalpha.Presentation.screens.Detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.Presentation.navigation.ScreenSealed
import com.example.ugly_galleryalpha.R
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme

@Composable
fun DetailPostScreen(
    navController: NavController

){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectHorizontalDragGestures { change, dragAmount ->
                    if (dragAmount > 0) {
                        navController.navigate(ScreenSealed.Home.route) {
                            popUpTo(ScreenSealed.Home.route) { inclusive = true }
                        }
                    }
                }
            }
    ){
        Spacer(modifier = Modifier.padding(8.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth()
        ){
            // Название Работы
            Text(
                text = "name_work",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
                )

            Icon(painter = painterResource(id = R.drawable.baseline_share_24), contentDescription = null)
        }

        // Информация о работе
        InfoPostAvtar()

        Spacer(modifier = Modifier.padding(top = 40.dp))
        //работа автора
        Box(
            modifier = Modifier
                .size(307.dp)
                .background(color = Color.Gray, shape = RoundedCornerShape(16.dp))
                .align(Alignment.CenterHorizontally)
        ){
            
        }

        Spacer(modifier = Modifier.padding(8.dp))

        //описание
        Text(modifier = Modifier.padding(start = 48.dp, end = 48.dp),
            text = "opisanie")

    }
}

//тест модели ->


@Preview(showBackground = true)
@Composable
fun DetailPostPreview() {
    Ugly_galleryALPHATheme {
        DetailPostScreen(rememberNavController())
    }
}

