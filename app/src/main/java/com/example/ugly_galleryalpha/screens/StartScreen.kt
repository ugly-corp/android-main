package com.example.ugly_galleryalpha.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
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
import com.example.ugly_galleryalpha.navigation.ScreenSealed
import com.example.ugly_galleryalpha.ui.theme.UGreen
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme


// Экран регистрации или входа
@Composable
fun StartScreen(
    navController: NavController
){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.bg_start),
                contentScale = ContentScale.Crop
            )
    ){

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                color = Color.White,
                fontSize = 64.sp,
                text = "UGLY",
                modifier = Modifier
                    .padding(start = 16.dp)
            )
            Text(
                color = Color.White,
                fontSize = 64.sp,
                text = "GALLERY",
                modifier = Modifier
                    .padding(start = 16.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Создать Аккаунт
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                onClick = {
                    navController.navigate(route = ScreenSealed.Auth.route)
                },
                colors = ButtonDefaults.buttonColors(Color.Black),
            ) {
                Text(
                    text = "Создать аккаунт",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Войти
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp, bottom = 48.dp),
                onClick = {
                    navController.navigate(route = ScreenSealed.Register.route)
                },
                colors = ButtonDefaults.buttonColors(UGreen),
            ) {
                Text(
                    text = "Войти",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ugly_galleryALPHATheme {
        StartScreen(
            navController = rememberNavController()
        )
    }
}