package com.example.ugly_galleryalpha.Presentation.screens.Start

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SnackbarDefaults.color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.R
import com.example.ugly_galleryalpha.Presentation.navigation.ScreenSealed
import com.example.ugly_galleryalpha.ui.theme.UGBlack
import com.example.ugly_galleryalpha.ui.theme.UGGray
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
            .background(color = UGBlack)
    ){

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                Image(painter = painterResource(id = R.drawable.u_bukva), contentDescription = null, Modifier.size(160.dp))
                Image(painter = painterResource(id = R.drawable.g_bukva), contentDescription = null, Modifier.size(160.dp))
            }
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
                colors = ButtonDefaults.buttonColors(UGreen),
            ) {
                Text(
                    text = "Регистрация",
                    color = UGBlack,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Войти
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp, bottom = 48.dp),
                onClick = {
                    navController.navigate(route = ScreenSealed.Register.route)
                },
                colors = ButtonDefaults.buttonColors(UGBlack),
                border = BorderStroke(2.dp, Color.White)
            ) {
                Text(
                    text = "Вход",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                modifier = Modifier.padding(start = 32.dp, end = 32.dp),
                color = UGGray,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    lineHeight = 11.sp
                ),
                text = buildAnnotatedString {
                    append("Продолжая, вы соглашаетесь с положением основных документов UG. Это ")
                    withStyle(style = SpanStyle(color = Color.White, fontWeight = FontWeight.Bold)) {
                        append("условия использования")
                    }
                    append(" и ")
                    withStyle(style = SpanStyle(color = Color.White, fontWeight = FontWeight.Bold)) {
                        append("политика конфиденциальности")
                    }
                    append(". А также подтверждаете, что прочли их.")
                }
            )
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